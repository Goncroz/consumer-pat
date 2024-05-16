package br.com.alelo.consumer.consumerpat.controller;
import br.com.alelo.consumer.consumerpat.entity.ContactInfo;
import br.com.alelo.consumer.consumerpat.service.ContactInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/contact-info")
public class ContactInfoController {

    private final ContactInfoService contactInfoService;

    @Autowired
    public ContactInfoController(ContactInfoService contactInfoService) {
        this.contactInfoService = contactInfoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactInfo> getContactInfoById(@PathVariable("id") Long id) {
        ContactInfo contactInfo = contactInfoService.getContactInfoById(id);
        return new ResponseEntity<>(contactInfo, HttpStatus.OK);
    }

}
