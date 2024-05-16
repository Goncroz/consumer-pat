package br.com.alelo.consumer.consumerpat.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;

    private Integer number;

    private String city;

    private String country;

    private Integer portalCode;

    @JsonCreator
    public Address(@JsonProperty("street") String street,
                   @JsonProperty("number") Integer number,
                   @JsonProperty("city") String city,
                   @JsonProperty("country") String country,
                   @JsonProperty("portalCode") String portalCode) {
        this.street = street;
        this.number = number;
        this.city = city;
        this.country = country;
        this.portalCode = Integer.valueOf(portalCode);
    }
}
