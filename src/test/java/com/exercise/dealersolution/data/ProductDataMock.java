package com.exercise.dealersolution.data;

import com.exercise.dealersolution.business.model.domain.ProductDomain;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class ProductDataMock {

    public static List<ProductDomain> getListProductDomainMock(){

        return Arrays.asList(
                ProductDomain.builder().id(UUID.fromString("e9b63118-169b-46e8-a8f1-cfbe3375ef37")).description("SUV").status(1).quantity(1).price(Double.valueOf(120000)).quantity(100).deadLine(LocalDate.of(2022, 12, 31)).build(),
                ProductDomain.builder().id(UUID.fromString("ba87d1be-e1b8-41e4-be9a-38dff66cdb54")).description("Sedan").status(1).quantity(1).price(Double.valueOf(100000)).quantity(100).deadLine(LocalDate.of(2022, 11, 20)).build(),
                ProductDomain.builder().id(UUID.fromString("307153ff-5dbe-4165-8c5f-c3af37f245d4")).description("Hatch1").status(0).quantity(0).price(Double.valueOf(40000)).quantity(100).deadLine(LocalDate.of(2099, 12, 31)).build(),
                ProductDomain.builder().id(UUID.fromString("205c6660-de35-4109-8c37-5a1efd569ed3")).description("Hatch2").status(1).quantity(1).price(Double.valueOf(50000)).quantity(0).deadLine(LocalDate.of(2022, 5, 10)).build(),
                ProductDomain.builder().id(UUID.fromString("d0105b3d-23e0-4f0e-ac72-f09231ed9933")).description("Sport").status(2).quantity(2).price(Double.valueOf(220000)).quantity(100).deadLine(LocalDate.of(2023, 4, 3)).build(),
                ProductDomain.builder().id(UUID.fromString("63b59fe1-5099-4a47-bb23-581bfeeaf36d")).description("Truck").status(1).quantity(1).price(Double.valueOf(250000)).quantity(100).deadLine(LocalDate.of(2024, 2, 1)).build(),
                ProductDomain.builder().id(UUID.fromString("85668199-e442-459e-8d50-ada6db203334")).description("Eletric").status(2).quantity(2).price(Double.valueOf(300000)).quantity(100).deadLine(LocalDate.of(2025, 6, 30)).build(),
                ProductDomain.builder().id(UUID.fromString("98668199-e442-459e-8d50-ada6db203776")).description("Autonomos").status(0).quantity(0).price(Double.valueOf(520000)).quantity(100).deadLine(LocalDate.of(2022, 12, 12)).build()
        );
    }

    public static List<ProductDomain> getListProductDomainAvailableMock(){
        return Arrays.asList(
                ProductDomain.builder().id(UUID.fromString("e9b63118-169b-46e8-a8f1-cfbe3375ef37")).description("SUV").status(2).quantity(1).price(Double.valueOf(120000)).quantity(100).deadLine(LocalDate.of(2022, 12, 31)).build(),
                ProductDomain.builder().id(UUID.fromString("ba87d1be-e1b8-41e4-be9a-38dff66cdb54")).description("Sedan").status(2).quantity(1).price(Double.valueOf(100000)).quantity(100).deadLine(LocalDate.of(2022, 11, 20)).build(),
                ProductDomain.builder().id(UUID.fromString("307153ff-5dbe-4165-8c5f-c3af37f245d4")).description("Hatch1").status(2).quantity(0).price(Double.valueOf(40000)).quantity(100).deadLine(LocalDate.of(2099, 12, 31)).build(),
                ProductDomain.builder().id(UUID.fromString("205c6660-de35-4109-8c37-5a1efd569ed3")).description("Hatch2").status(2).quantity(1).price(Double.valueOf(50000)).quantity(0).deadLine(LocalDate.of(2022, 5, 10)).build(),
                ProductDomain.builder().id(UUID.fromString("d0105b3d-23e0-4f0e-ac72-f09231ed9933")).description("Sport").status(2).quantity(2).price(Double.valueOf(220000)).quantity(100).deadLine(LocalDate.of(2023, 4, 3)).build(),
                ProductDomain.builder().id(UUID.fromString("63b59fe1-5099-4a47-bb23-581bfeeaf36d")).description("Truck").status(2).quantity(1).price(Double.valueOf(250000)).quantity(100).deadLine(LocalDate.of(2024, 2, 1)).build(),
                ProductDomain.builder().id(UUID.fromString("85668199-e442-459e-8d50-ada6db203334")).description("Eletric").status(2).quantity(2).price(Double.valueOf(300000)).quantity(100).deadLine(LocalDate.of(2025, 6, 30)).build(),
                ProductDomain.builder().id(UUID.fromString("98668199-e442-459e-8d50-ada6db203776")).description("Autonomos").status(2).quantity(0).price(Double.valueOf(520000)).quantity(100).deadLine(LocalDate.of(2022, 12, 12)).build()
        );
    }

    public static ProductDomain getProductDomainMock(){
        return ProductDomain.
                builder().
                id(UUID.fromString("e9b63118-169b-46e8-a8f1-cfbe3375ef37")).
                description("SUV").
                status(2).
                quantity(1).
                price(Double.valueOf(120000)).
                quantity(100).
                deadLine(LocalDate.of(2022, 12, 31))
                .build();
    }
}
