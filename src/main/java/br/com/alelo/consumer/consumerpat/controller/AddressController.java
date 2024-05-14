package br.com.alelo.consumer.consumerpat.controller;

import br.com.alelo.consumer.consumerpat.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import br.com.alelo.consumer.consumerpat.entity.Address;


@RestController
@RequestMapping("/addresses")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Address>> getAllAddresses() {
        List<Address> addresses = addressService.getAllAddresses();
        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable("id") Long id) {
        Address address = addressService.getAddressById(id);
        return new ResponseEntity<>(address, HttpStatus.OK);
    }

    // Endpoint para buscar endereços por rua
    @GetMapping("/byStreet")
    public ResponseEntity<List<Address>> getAddressesByStreet(@RequestParam String street) {
        List<Address> addresses = addressService.getAddressesByStreet(street);
        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }

    // Endpoint para buscar endereços por cidade
    @GetMapping("/byCity")
    public ResponseEntity<List<Address>> getAddressesByCity(@RequestParam String city) {
        List<Address> addresses = addressService.getAddressesByCity(city);
        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }

}
