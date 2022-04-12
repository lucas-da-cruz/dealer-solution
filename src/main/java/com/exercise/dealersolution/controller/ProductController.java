package com.exercise.dealersolution.controller;

import com.exercise.dealersolution.business.ProductService;
import com.exercise.dealersolution.business.model.domain.ProductDomain;
import com.exercise.dealersolution.business.model.enumDomain.StatusProduto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/dealer")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

  private final ProductService productService;

  @GetMapping("/models")
  public ResponseEntity<List<ProductDomain>> retrieveAll() {
      log.info("Dealer-solution - {} - Iniciando busca de todos os produtos", LocalDateTime.now());
      return ResponseEntity.ok(productService.todos());
  }

  @GetMapping("/models/available")
  public ResponseEntity<List<ProductDomain>> getAll() {
      log.info("Dealer-solution - {} - Iniciando busca de todos os produtos com status igual a {}", LocalDateTime.now(), StatusProduto.AVAILABLE.getStatus());
      return ResponseEntity.ok(productService.retrieveProductByStatus(StatusProduto.AVAILABLE.getStatus()));
  }

  @GetMapping("/models/{id}")
  public ResponseEntity<LocalDate> retrieveDeadline(@PathVariable String id) throws Exception {
      log.info("Dealer-solution - {} - Iniciando busca de data de deadLine para o ID produto {}", LocalDateTime.now(), id);
      return ResponseEntity.ok(productService.retrieveDeadline(id));
  }

  @PostMapping("/models/new")
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<UUID> addNewProductModel(@RequestBody @Valid ProductDomain productDomain) {
      log.info("Dealer-solution - {} - Adicionando novo produto", LocalDateTime.now());
      return ResponseEntity.ok(productService.save(productDomain));
  }

  @DeleteMapping("/models")
  public void apagarItens(@RequestBody List<String> uuidProducts) {
      log.info("Dealer-solution - {} - Adicionando novo produto", LocalDateTime.now());
      productService.removeItens(uuidProducts);
  }

  @DeleteMapping("/models/{idProduto}")
  public void delete(@PathVariable String idProduto) {
      log.info("Dealer-solution - {} - Removendo o produto com id igual a {}", LocalDateTime.now(), idProduto);
      productService.remove(idProduto);
  }

  @PatchMapping("/model/{idProduto}")
  public void updateProduct(@PathVariable String idProduto, @RequestBody @Valid ProductDomain productDomain) throws Exception {
      log.info("Dealer-solution - {} - Atualizando o produto com id igual a {}", LocalDateTime.now(), idProduto);
      productService.updateProducts(idProduto, productDomain);
  }

  @PutMapping("/model/{idProduto}/{priceProduct}")
  public void updateProductPrice(@PathVariable String idProduto, @PathVariable Double priceProduct) throws Exception {
      log.info("Dealer-solution - {} - Atualizando preço do produto com id igual a {}", LocalDateTime.now(), idProduto);
      productService.updateProductPrice(idProduto, priceProduct);
  }

}
