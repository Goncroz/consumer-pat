package br.com.alelo.consumer.consumerpat.dto;

import lombok.Data;

@Data
public class ContactInfoDTO {

    private Long mobilePhoneNumber;

    private Long residencePhoneNumber;

    private Long phoneNumber;

    private String email;
}
