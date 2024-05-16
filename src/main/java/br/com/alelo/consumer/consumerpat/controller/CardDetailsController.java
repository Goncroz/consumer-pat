package br.com.alelo.consumer.consumerpat.controller;
import br.com.alelo.consumer.consumerpat.entity.CardDetails;
import br.com.alelo.consumer.consumerpat.service.CardDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/card-details")
public class CardDetailsController {

    private final CardDetailsService cardDetailsService;

    @Autowired
    public CardDetailsController(CardDetailsService cardDetailsService) {
        this.cardDetailsService = cardDetailsService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CardDetails> getCardDetailsById(@PathVariable("id") Long id) {
        CardDetails cardDetails = cardDetailsService.getCardDetailsById(id);
        return new ResponseEntity<>(cardDetails, HttpStatus.OK);
    }

}
