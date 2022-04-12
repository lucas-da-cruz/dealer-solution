package com.exercise.dealersolution.business.model.domain;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Builder
@ToString
public class ProductDomain {

    public ProductDomain(UUID id, String description, Integer status, Double price, Integer quantity, LocalDate deadLine) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.price = price;
        this.quantity = quantity;
        this.deadLine = deadLine;
    }

    private UUID id;
    @NotNull
    @NotBlank
    private String description;
    @NotNull
    private Integer status;
    @NotNull
    private Double price;
    @NotNull
    private Integer quantity;
    @NotNull
    private LocalDate deadLine;

}
