package br.com.alelo.consumer.consumerpat.dto;

import lombok.Data;
import java.time.LocalDate;


@Data
public class ConsumerDTO {

    private Long id;

    private String name;

    private Long documentNumber;

    private LocalDate birthDate;

    private ContactInfoDTO contact;

    private AddressDTO address;

    private CardDetailsDTO cards;
}
