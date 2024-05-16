package br.com.alelo.consumer.consumerpat.controller;

import br.com.alelo.consumer.consumerpat.entity.Consumer;
import br.com.alelo.consumer.consumerpat.service.ConsumerService;
import br.com.alelo.consumer.consumerpat.service.ExtractService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ConsumerController.class)
class ConsumerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ConsumerService consumerService;

    @MockBean
    private ExtractService extractService;

    private Consumer consumer;

    @BeforeEach
    void setUp() {
        consumer = new Consumer();
        consumer.setId(1L);
        consumer.setName("John Doe");
    }

    @Test
    void testListAllConsumers() throws Exception {
        List<Consumer> consumers = Arrays.asList(consumer);
        when(consumerService.getAllConsumers()).thenReturn(consumers);

        mockMvc.perform(get("/consumers/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("John Doe"));

        verify(consumerService, times(1)).getAllConsumers();
    }

    @Test
    void testCreateConsumer() throws Exception {
        String consumerJson = "{\"id\":1,\"name\":\"John Doe\"}";

        mockMvc.perform(post("/consumers/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(consumerJson))
                .andExpect(status().isCreated());

        verify(consumerService, times(1)).createConsumer(any(Consumer.class));
    }

    @Test
    void testUpdateConsumer() throws Exception {
        String consumerJson = "{\"id\":1,\"name\":\"John Doe\"}";

        mockMvc.perform(put("/consumers/update/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(consumerJson))
                .andExpect(status().isNoContent());

        verify(consumerService, times(1)).updateConsumer(any(Consumer.class));
    }

    @Test
    void testAddBalanceToCard() throws Exception {
        mockMvc.perform(post("/consumers/add-balance")
                        .param("cardNumber", "123456")
                        .param("value", "50.0"))
                .andExpect(status().isNoContent());

        verify(consumerService, times(1)).addBalanceToCard(123456, 50.0);
    }

    @Test
    void testBuy() throws Exception {
        mockMvc.perform(post("/consumers/buy")
                        .param("establishmentType", "1")
                        .param("establishmentName", "Supermarket")
                        .param("cardNumber", "123456")
                        .param("productDescription", "Groceries")
                        .param("value", "50.0"))
                .andExpect(status().isNoContent());

        verify(consumerService, times(1)).processPurchase(1, "Supermarket", 123456, "Groceries", 50.0);
    }
}

