package br.com.alelo.consumer.consumerpat.service;

import br.com.alelo.consumer.consumerpat.entity.CardDetails;
import br.com.alelo.consumer.consumerpat.entity.Consumer;
import br.com.alelo.consumer.consumerpat.respository.CardDetailsRepository;
import br.com.alelo.consumer.consumerpat.respository.ConsumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsumerService {

    private final ConsumerRepository consumerRepository;
    private final CardDetailsRepository cardDetailsRepository;

    @Autowired
    public ConsumerService(ConsumerRepository consumerRepository, CardDetailsRepository cardDetailsRepository) {
        this.consumerRepository = consumerRepository;
        this.cardDetailsRepository = cardDetailsRepository;
    }

    public List<Consumer> getAllConsumers() {
        return consumerRepository.findAll();
    }

    public void createConsumer(Consumer consumer) {
        consumerRepository.save(consumer);
    }

    public void updateConsumer(Consumer consumer) {
        Long consumerId = consumer.getId();

        Optional<Consumer> existingConsumerOptional = consumerRepository.findById(consumerId);

        if (existingConsumerOptional.isPresent()) {
            Consumer existingConsumer = existingConsumerOptional.get();
            existingConsumer.setName(consumer.getName());
            existingConsumer.setDocumentNumber(consumer.getDocumentNumber());
            existingConsumer.setBirthDate(consumer.getBirthDate());
            existingConsumer.setContactInfo(consumer.getContactInfo());
            existingConsumer.setAddress(consumer.getAddress());
            existingConsumer.setCardDetails(consumer.getCardDetails());

            consumerRepository.save(existingConsumer);
        } else {
            throw new IllegalArgumentException("Consumer with ID " + consumerId + " not found");
        }
    }

    public void addBalanceToCard(int cardNumber, double value) {
        Optional<CardDetails> cardDetailsOptional = Optional.ofNullable(cardDetailsRepository.findById(cardNumber));
        if (cardDetailsOptional.isPresent()) {
            CardDetails cardDetails = cardDetailsOptional.get();
            if (cardDetails.getFoodCardNumber() == cardNumber) {
                cardDetails.setFoodCardBalance(cardDetails.getFoodCardBalance() + value);
            } else if (cardDetails.getDrugstoreNumber() == cardNumber) {
                cardDetails.setDrugstoreCardBalance(cardDetails.getDrugstoreCardBalance() + value);
            } else if (cardDetails.getFuelCardNumber() == cardNumber) {
                cardDetails.setFuelCardBalance(cardDetails.getFuelCardBalance() + value);
            }
            cardDetailsRepository.save(cardDetails);
        } else {
            throw new IllegalArgumentException("CardDetails not found for card number: " + cardNumber);
        }
    }

    public void processPurchase(int establishmentType, String establishmentName, int cardNumber, String productDescription, double value) {

    }
}
