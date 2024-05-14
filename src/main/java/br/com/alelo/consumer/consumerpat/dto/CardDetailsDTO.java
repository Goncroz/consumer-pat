package br.com.alelo.consumer.consumerpat.dto;

import lombok.Data;

@Data
public class CardDetailsDTO {

    private Long foodCardNumber;

    private Double foodCardBalance;

    private Long fuelCardNumber;

    private Double fuelCardBalance;

    private Long drugstoreNumber;

    private Double drugstoreCardBalance;
}
