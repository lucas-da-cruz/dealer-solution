package com.exercise.dealersolution.repository;

import com.exercise.dealersolution.business.model.domain.ProductDomain;

import java.util.List;
import java.util.UUID;

public interface ProductRepository {

    List<ProductDomain> todos();
    ProductDomain getProduct(UUID idProduto) throws Exception;
    UUID save(ProductDomain novoProduto);
    void updateProducts(UUID idProduto, ProductDomain productNew) throws Exception;
    void remove(UUID productID);
    List<ProductDomain> retrieveProductByStatus(Integer status);
    List<ProductDomain> retrieveUnavailable();
}
