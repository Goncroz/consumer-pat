package br.com.alelo.consumer.consumerpat.respository;

import br.com.alelo.consumer.consumerpat.entity.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConsumerRepository extends JpaRepository<Consumer, Integer> {


    @Query(nativeQuery = true, value = "SELECT * FROM Consumer WHERE FOOD_CARD_NUMBER = ?1 AND FUEL_CARD_NUMBER = ?2 AND DRUGSTORE_NUMBER = ?3")
    List<Consumer> findAllByFoodCardNumberAndFuelCardNumberAndDrugstoreNumber(Long foodCardNumber, Long fuelCardNumber, Long drugstoreNumber);

    Optional<Consumer> findById(Long consumerId);
}
