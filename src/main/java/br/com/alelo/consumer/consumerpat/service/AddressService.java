package br.com.alelo.consumer.consumerpat.service;

import br.com.alelo.consumer.consumerpat.respository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import br.com.alelo.consumer.consumerpat.entity.Address;

import javax.persistence.EntityNotFoundException;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public Address getAddressById(Long id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Address not found with id: " + id));
    }

    public List<Address> getAddressesByStreet(String street) {
        return addressRepository.findByStreet(street);
    }

    public List<Address> getAddressesByCity(String city) {
        return addressRepository.findByCity(city);
    }

}
