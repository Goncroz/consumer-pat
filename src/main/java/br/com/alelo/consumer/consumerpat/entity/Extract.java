package br.com.alelo.consumer.consumerpat.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
public class Extract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "establishment_name_id")
    private Long establishmentNameId;

    @Column(name = "establishment_name")
    private String establishmentName;

    @Column(name = "product_description")
    private String productDescription;

    @Column(name = "date_buy")
    private LocalDate dateBuy;

    @Column(name = "card_number")
    private Integer cardNumber;

    @Column(name = "amount")
    private Double amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEstablishmentNameId() {
        return establishmentNameId;
    }

    public void setEstablishmentNameId(Long establishmentNameId) {
        this.establishmentNameId = establishmentNameId;
    }

    public String getEstablishmentName() {
        return establishmentName;
    }

    public void setEstablishmentName(String establishmentName) {
        this.establishmentName = establishmentName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public LocalDate getDateBuy() {
        return dateBuy;
    }

    public void setDateBuy(LocalDate dateBuy) {
        this.dateBuy = dateBuy;
    }

    public Integer getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Integer cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Extract(String establishmentName, String productDescription, LocalDate dateBuy, int cardNumber, double amount) {

    }
}
