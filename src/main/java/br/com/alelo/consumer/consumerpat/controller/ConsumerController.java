package br.com.alelo.consumer.consumerpat.controller;

import br.com.alelo.consumer.consumerpat.service.ConsumerService;
import br.com.alelo.consumer.consumerpat.service.ExtractService;
import br.com.alelo.consumer.consumerpat.entity.Consumer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/consumers")
public class ConsumerController {

    private final ConsumerService consumerService;
    private final ExtractService extractService;

    public ConsumerController(ConsumerService consumerService, ExtractService extractService) {
        this.consumerService = consumerService;
        this.extractService = extractService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Consumer>> listAllConsumers() {
        List<Consumer> consumers = consumerService.getAllConsumers();
        return ResponseEntity.ok(consumers);
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createConsumer(@RequestBody Consumer consumer) {
        consumerService.createConsumer(consumer);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateConsumer(@RequestBody Consumer consumer) {
        consumerService.updateConsumer(consumer);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/add-balance")
    public ResponseEntity<Void> addBalanceToCard(@RequestParam int cardNumber, @RequestParam double value) {
        consumerService.addBalanceToCard(cardNumber, value);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/buy")
    public ResponseEntity<Void> buy(@RequestParam int establishmentType,
                                    @RequestParam String establishmentName,
                                    @RequestParam int cardNumber,
                                    @RequestParam String productDescription,
                                    @RequestParam double value) {
        consumerService.processPurchase(establishmentType, establishmentName, cardNumber, productDescription, value);
        return ResponseEntity.noContent().build();
    }
}
