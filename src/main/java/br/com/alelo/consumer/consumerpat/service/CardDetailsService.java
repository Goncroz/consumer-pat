package br.com.alelo.consumer.consumerpat.service;

import br.com.alelo.consumer.consumerpat.entity.CardDetails;
import br.com.alelo.consumer.consumerpat.respository.CardDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class CardDetailsService {

    private final CardDetailsRepository cardDetailsRepository;

    @Autowired
    public CardDetailsService(CardDetailsRepository cardDetailsRepository) {
        this.cardDetailsRepository = cardDetailsRepository;
    }

    public CardDetails getCardDetailsById(Long id) {
        return cardDetailsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("CardDetails not found with id: " + id));
    }

}
