package br.com.alelo.consumer.consumerpat.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class ExtractDTO {

    private Long id;

    private String establishmentName;

    private String productDescription;

    private LocalDate purchaseDate;

    private Double amount;
}
