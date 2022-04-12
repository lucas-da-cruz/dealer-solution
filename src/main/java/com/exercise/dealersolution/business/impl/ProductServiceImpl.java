package com.exercise.dealersolution.business.impl;

import com.exercise.dealersolution.business.ProductService;
import com.exercise.dealersolution.business.model.domain.ProductDomain;
import com.exercise.dealersolution.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<ProductDomain> todos(){
        return productRepository.todos();
    }

    @Override
    public List<ProductDomain> retrieveProductByStatus(Integer status){
        return productRepository.retrieveProductByStatus(status);
    }

    @Override
    public LocalDate retrieveDeadline(String id) throws Exception {
        return productRepository.getProduct(UUID.fromString(id)).getDeadLine();
    }

    @Override
    public UUID save(ProductDomain productDomain){
        return productRepository.save(productDomain);
    }

    @Override
    public void remove(String uuid){
        productRepository.remove(UUID.fromString(uuid));
    }

    @Override
    public void removeItens(List<String> uuidProducts){
        uuidProducts.forEach(uuid -> productRepository.remove(UUID.fromString(uuid)));
    }

    @Override
    public void updateProducts(String idProduto, ProductDomain productDomain) throws Exception {
        productRepository.updateProducts(UUID.fromString(idProduto), productDomain);
    }

    @Override
    public void updateProductPrice(String idProduto, Double priceProduct) throws Exception {
        ProductDomain productDomain = productRepository.getProduct(UUID.fromString(idProduto));
        productDomain.setPrice(priceProduct);
        productRepository.updateProducts(UUID.fromString(idProduto), productDomain);
    }
}
