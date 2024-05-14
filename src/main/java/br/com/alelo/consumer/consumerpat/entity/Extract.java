package br.com.alelo.consumer.consumerpat.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
public class Extract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    public Extract(String establishmentName, String productDescription, Date date, int cardNumber, double value) {
    }
}
