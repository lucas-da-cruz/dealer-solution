package com.exercise.dealersolution.business;

import com.exercise.dealersolution.business.model.domain.ProductDomain;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface ProductService {

    List<ProductDomain> todos();
    List<ProductDomain> retrieveProductByStatus(Integer status);
    LocalDate retrieveDeadline(String id) throws Exception;
    UUID save(ProductDomain productDomain);
    void remove(String uuid);
    void removeItens(List<String> uuidProducts);
    void updateProducts(String idProduto, ProductDomain productDomain) throws Exception;
    void updateProductPrice(String idProduto, Double priceProduct) throws Exception;
}
