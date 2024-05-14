package br.com.alelo.consumer.consumerpat.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


import br.com.alelo.consumer.consumerpat.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    Address findById(long id);

    List<Address> findByStreet(String street);

    List<Address> findByCity(String city);
}
