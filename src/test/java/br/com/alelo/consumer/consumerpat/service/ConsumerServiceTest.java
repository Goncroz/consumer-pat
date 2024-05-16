package br.com.alelo.consumer.consumerpat.service;

import br.com.alelo.consumer.consumerpat.entity.CardDetails;
import br.com.alelo.consumer.consumerpat.entity.Consumer;
import br.com.alelo.consumer.consumerpat.respository.CardDetailsRepository;
import br.com.alelo.consumer.consumerpat.respository.ConsumerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ConsumerServiceTest {

    @Mock
    private ConsumerRepository consumerRepository;

    @Mock
    private CardDetailsRepository cardDetailsRepository;

    @InjectMocks
    private ConsumerService consumerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllConsumers() {
        Consumer consumer1 = new Consumer();
        Consumer consumer2 = new Consumer();

        when(consumerRepository.findAll()).thenReturn(Arrays.asList(consumer1, consumer2));

        assertEquals(2, consumerService.getAllConsumers().size());
        verify(consumerRepository, times(1)).findAll();
    }

    @Test
    void testCreateConsumer() {
        Consumer consumer = new Consumer();
        consumerService.createConsumer(consumer);
        verify(consumerRepository, times(1)).save(consumer);
    }

    @Test
    void testUpdateConsumer_ConsumerExists() {
        Consumer consumer = new Consumer();
        consumer.setId(1L);
        consumer.setName("Updated Name");

        Consumer existingConsumer = new Consumer();
        existingConsumer.setId(1L);

        when(consumerRepository.findById(1L)).thenReturn(Optional.of(existingConsumer));

        consumerService.updateConsumer(consumer);

        assertEquals("Updated Name", existingConsumer.getName());
        verify(consumerRepository, times(1)).save(existingConsumer);
    }

    @Test
    void testUpdateConsumer_ConsumerNotFound() {
        Consumer consumer = new Consumer();
        consumer.setId(1L);

        when(consumerRepository.findById(1L)).thenReturn(Optional.empty());

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            consumerService.updateConsumer(consumer);
        });

        assertEquals("Consumer with ID 1 not found", exception.getMessage());
    }

    @Test
    void testAddBalanceToCard_CardExists() {
        CardDetails cardDetails = new CardDetails();
        cardDetails.setFoodCardNumber(12345L);
        cardDetails.setFoodCardBalance(100.0);

        when(cardDetailsRepository.findById(12345)).thenReturn(cardDetails);

        consumerService.addBalanceToCard(12345, 50.0);

        assertEquals(150.0, cardDetails.getFoodCardBalance());
        verify(cardDetailsRepository, times(1)).save(cardDetails);
    }

    @Test
    void testAddBalanceToCard_CardNotFound() {
        when(cardDetailsRepository.findById(12345)).thenReturn(null);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            consumerService.addBalanceToCard(12345, 50.0);
        });

        assertEquals("CardDetails not found for card number: 12345", exception.getMessage());
    }
}

