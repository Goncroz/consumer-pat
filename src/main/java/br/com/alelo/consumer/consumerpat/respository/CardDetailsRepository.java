package br.com.alelo.consumer.consumerpat.respository;

import br.com.alelo.consumer.consumerpat.entity.CardDetails;
import br.com.alelo.consumer.consumerpat.entity.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardDetailsRepository extends JpaRepository<CardDetails, Long> {

    CardDetails findById(long id);

    Consumer findByFoodCardNumber(int cardNumber);

    Consumer findByFuelCardNumber(int cardNumber);

    Consumer findByDrugstoreNumber(int cardNumber);
}
