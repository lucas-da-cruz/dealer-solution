package com.exercise.dealersolution.repository.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.UUID;
import java.util.stream.Collectors;

import com.exercise.dealersolution.business.model.domain.ProductDomain;
import com.exercise.dealersolution.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static com.exercise.dealersolution.common.utils.Utils.QUANTIY_ZERO;

@Component
@Slf4j
public class ProductRepositoryImpl implements ProductRepository {

  List<ProductDomain> productList = new ArrayList<>();

  public ProductRepositoryImpl() {
    productList.add(ProductDomain.builder().id(UUID.fromString("e9b63118-169b-46e8-a8f1-cfbe3375ef37")).description("SUV").status(1).quantity(1).price(Double.valueOf(120000)).quantity(100).deadLine(LocalDate.of(2022, 12, 31)).build());
    productList.add(ProductDomain.builder().id(UUID.fromString("ba87d1be-e1b8-41e4-be9a-38dff66cdb54")).description("Sedan").status(1).quantity(1).price(Double.valueOf(100000)).quantity(100).deadLine(LocalDate.of(2022, 11, 20)).build());
    productList.add(ProductDomain.builder().id(UUID.fromString("307153ff-5dbe-4165-8c5f-c3af37f245d4")).description("Hatch1").status(0).quantity(0).price(Double.valueOf(40000)).quantity(100).deadLine(LocalDate.of(2099, 12, 31)).build());
    productList.add(ProductDomain.builder().id(UUID.fromString("205c6660-de35-4109-8c37-5a1efd569ed3")).description("Hatch2").status(1).quantity(1).price(Double.valueOf(50000)).quantity(0).deadLine(LocalDate.of(2022, 5, 10)).build());
    productList.add(ProductDomain.builder().id(UUID.fromString("d0105b3d-23e0-4f0e-ac72-f09231ed9933")).description("Sport").status(2).quantity(2).price(Double.valueOf(220000)).quantity(100).deadLine(LocalDate.of(2023, 4, 3)).build());
    productList.add(ProductDomain.builder().id(UUID.fromString("63b59fe1-5099-4a47-bb23-581bfeeaf36d")).description("Truck").status(1).quantity(1).price(Double.valueOf(250000)).quantity(100).deadLine(LocalDate.of(2024, 2, 1)).build());
    productList.add(ProductDomain.builder().id(UUID.fromString("85668199-e442-459e-8d50-ada6db203334")).description("Eletric").status(2).quantity(2).price(Double.valueOf(300000)).quantity(100).deadLine(LocalDate.of(2025, 6, 30)).build());
    productList.add(ProductDomain.builder().id(UUID.fromString("98668199-e442-459e-8d50-ada6db203776")).description("Autonomos").status(0).quantity(0).price(Double.valueOf(520000)).quantity(100).deadLine(LocalDate.of(2022, 12, 12)).build());
  }

  @Override
  public List<ProductDomain> todos(){
    return productList;
  }

  @Override
  public ProductDomain getProduct(UUID idProduto) throws Exception {
    return productList.stream().filter(productDomain -> productDomain.getId().equals(idProduto))
            .findFirst()
            .orElseThrow(() -> new Exception("Ops... ProductRepository not found"));
  }

  @Override
  public UUID save(ProductDomain novoProduto){
    UUID uuid = UUID.randomUUID();
    novoProduto.setId(uuid);
    productList.add(novoProduto);
    log.info("Dealer-solution - {} - produto inserido {}", LocalDateTime.now(), novoProduto);
    return uuid;
  }

  @Override
  public void updateProducts(UUID idProduto, ProductDomain productNew) throws Exception {
    ProductDomain productCurrent = productList.stream()
            .filter(product -> product.getId().equals(idProduto))
            .findFirst()
            .orElseThrow(() -> new Exception("Ops... ProductRepository not found"));

    productCurrent.setDeadLine(productNew.getDeadLine());
    productCurrent.setDescription(productNew.getDescription());
    productCurrent.setQuantity(productNew.getQuantity());
    productCurrent.setStatus(productNew.getStatus());
    productCurrent.setPrice(productNew.getPrice());

    log.info("Dealer-solution - {} - produto atualizado {}", LocalDateTime.now(), productCurrent);
  }

  @Override
  public void remove(UUID productID) {
    productList.removeIf(productDomain -> productDomain.getId().equals(productID));
    log.info("Dealer-solution - {} - produto com id {} removido", LocalDateTime.now(), productID);
  }

  @Override
  public List<ProductDomain> retrieveProductByStatus(Integer status){
    return productList.stream().filter(product -> product.getStatus().equals(status))
            .collect(Collectors.toList());
  }

  @Override
  public List<ProductDomain> retrieveUnavailable(){
    return productList.stream().filter(product -> product.getQuantity().equals(QUANTIY_ZERO))
            .collect(Collectors.toList());
  }

}
