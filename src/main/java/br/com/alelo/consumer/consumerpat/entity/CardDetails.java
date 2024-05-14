package br.com.alelo.consumer.consumerpat.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class CardDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long foodCardNumber;

    private Double foodCardBalance;

    private Long fuelCardNumber;

    private Double fuelCardBalance;

    private Long drugstoreNumber;

    private Double drugstoreCardBalance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFoodCardNumber() {
        return foodCardNumber;
    }

    public void setFoodCardNumber(Long foodCardNumber) {
        this.foodCardNumber = foodCardNumber;
    }

    public Double getFoodCardBalance() {
        return foodCardBalance;
    }

    public void setFoodCardBalance(Double foodCardBalance) {
        this.foodCardBalance = foodCardBalance;
    }

    public Long getFuelCardNumber() {
        return fuelCardNumber;
    }

    public void setFuelCardNumber(Long fuelCardNumber) {
        this.fuelCardNumber = fuelCardNumber;
    }

    public Double getFuelCardBalance() {
        return fuelCardBalance;
    }

    public void setFuelCardBalance(Double fuelCardBalance) {
        this.fuelCardBalance = fuelCardBalance;
    }

    public Long getDrugstoreNumber() {
        return drugstoreNumber;
    }

    public void setDrugstoreNumber(Long drugstoreNumber) {
        this.drugstoreNumber = drugstoreNumber;
    }

    public Double getDrugstoreCardBalance() {
        return drugstoreCardBalance;
    }

    public void setDrugstoreCardBalance(Double drugstoreCardBalance) {
        this.drugstoreCardBalance = drugstoreCardBalance;
    }
}
