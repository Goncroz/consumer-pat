package br.com.alelo.consumer.consumerpat.controller;

import br.com.alelo.consumer.consumerpat.service.ExtractService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/extracts")
public class ExtractController {

    private final ExtractService extractService;

    public ExtractController(ExtractService extractService) {
        this.extractService = extractService;
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createExtract(@RequestParam String establishmentName,
                                              @RequestParam String productDescription,
                                              @RequestParam Date date,
                                              @RequestParam int cardNumber,
                                              @RequestParam double value) {
        extractService.createExtract(establishmentName, productDescription, date, cardNumber, value);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
