package br.com.alelo.consumer.consumerpat.dto;

import lombok.Data;

@Data
public class AddressDTO {

    private String street;

    private Integer number;

    private String city;

    private String country;

    private Integer portalCode;
}
