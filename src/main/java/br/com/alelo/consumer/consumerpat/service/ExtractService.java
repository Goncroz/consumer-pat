package br.com.alelo.consumer.consumerpat.service;

import br.com.alelo.consumer.consumerpat.entity.Extract;
import br.com.alelo.consumer.consumerpat.respository.ExtractRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ExtractService {

    private final ExtractRepository extractRepository;

    public ExtractService(ExtractRepository extractRepository) {
        this.extractRepository = extractRepository;
    }

    public void createExtract(String establishmentName, String productDescription, Date date, int cardNumber, double value) {
        Extract extract = new Extract(establishmentName, productDescription, date, cardNumber, value);
        extractRepository.save(extract);
    }
}
