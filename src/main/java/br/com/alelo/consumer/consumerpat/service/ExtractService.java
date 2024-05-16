package br.com.alelo.consumer.consumerpat.service;

import br.com.alelo.consumer.consumerpat.entity.Extract;
import br.com.alelo.consumer.consumerpat.respository.ExtractRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ExtractService {

    private final ExtractRepository extractRepository;

    public ExtractService(ExtractRepository extractRepository) {
        this.extractRepository = extractRepository;
    }

    public void createExtract(String establishmentName, String productDescription, String dateString, int cardNumber, double value) {
        LocalDate date = LocalDate.parse(dateString);

        Extract extract = new Extract(establishmentName, productDescription, date, cardNumber, value);
        extractRepository.save(extract);
    }
}
