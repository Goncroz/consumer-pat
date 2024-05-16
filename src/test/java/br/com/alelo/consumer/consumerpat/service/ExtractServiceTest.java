package br.com.alelo.consumer.consumerpat.service;

import br.com.alelo.consumer.consumerpat.entity.Extract;
import br.com.alelo.consumer.consumerpat.respository.ExtractRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.mockito.Mockito.verify;

class ExtractServiceTest {

    @Mock
    private ExtractRepository extractRepository;

    private ExtractService extractService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        extractService = new ExtractService(extractRepository);
    }

    @Test
    void testCreateExtract() {
        String establishmentName = "Supermercado XYZ";
        String productDescription = "Compras de mercado";
        String dateString = "2024-05-15";
        int cardNumber = 123456;
        double value = 50.0;

        extractService.createExtract(establishmentName, productDescription, dateString, cardNumber, value);

        verify(extractRepository).save(new Extract(establishmentName, productDescription, LocalDate.parse(dateString), cardNumber, value));
    }
}
