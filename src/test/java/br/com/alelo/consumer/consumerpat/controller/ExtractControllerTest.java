package br.com.alelo.consumer.consumerpat.controller;

import br.com.alelo.consumer.consumerpat.service.ExtractService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ExtractController.class)
class ExtractControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ExtractService extractService;

    @Test
    void testCreateExtract() throws Exception {
        String establishmentName = "Supermercado XYZ";
        String productDescription = "Compras de mercado";
        String dateString = "2024-05-15";
        int cardNumber = 123456;
        double value = 50.0;

        mockMvc.perform(post("/extracts/create")
                        .param("establishmentName", establishmentName)
                        .param("productDescription", productDescription)
                        .param("date", dateString)
                        .param("cardNumber", String.valueOf(cardNumber))
                        .param("value", String.valueOf(value)))
                .andExpect(status().isCreated());
    }
}
