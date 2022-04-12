package com.exercise.dealersolution.business;

import com.exercise.dealersolution.business.impl.ProductServiceImpl;
import com.exercise.dealersolution.business.model.domain.ProductDomain;
import com.exercise.dealersolution.business.model.enumDomain.StatusProduto;
import com.exercise.dealersolution.repository.impl.ProductRepositoryImpl;
import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static com.exercise.dealersolution.data.ProductDataMock.*;
import static com.exercise.dealersolution.data.ProductDataMock.getProductDomainMock;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductRepositoryImplTest {

    @Mock
    private ProductRepositoryImpl productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    Gson gson = new Gson();

    @Test
    void shouldGetAllProducts() {
        //GIVEN
        List<ProductDomain> listProductDomainExpected = getListProductDomainMock();
        when(productRepository.todos()).thenReturn(listProductDomainExpected);

        //WHEN
        List<ProductDomain> listProductDomainCurrent = productService.todos();

        //THEN
        Assertions.assertNotNull(listProductDomainCurrent);
        verify(productRepository, times(1)).todos();
        verifyNoMoreInteractions(productRepository);
        assertEquals(gson.toJson(listProductDomainExpected), gson.toJson(listProductDomainCurrent));
    }

    @Test
    void shouldGetAllAvailableProducts() {
        //GIVEN
        List<ProductDomain> listProductDomainExpected = getListProductDomainAvailableMock();
        Integer statusAvailable = StatusProduto.AVAILABLE.getStatus();
        when(productRepository.retrieveProductByStatus(statusAvailable)).thenReturn(listProductDomainExpected);

        //WHEN
        List<ProductDomain> listProductDomainCurrent = productService.retrieveProductByStatus(statusAvailable);

        //THEN
        Assertions.assertNotNull(listProductDomainCurrent);
        verify(productRepository, times(1)).retrieveProductByStatus(statusAvailable);
        verifyNoMoreInteractions(productRepository);
        assertEquals(gson.toJson(listProductDomainExpected), gson.toJson(listProductDomainCurrent));
    }


    @Test
    void shouldRetrieveDeadline() throws Exception {
        //GIVEN
        ProductDomain productDomainExpected = getListProductDomainAvailableMock().get(0);
        UUID uuid = UUID.fromString("e9b63118-169b-46e8-a8f1-cfbe3375ef37");
        when(productRepository.getProduct(uuid)).thenReturn(productDomainExpected);

        //WHEN
        LocalDate deadLine = productService.retrieveDeadline(uuid.toString());

        //THEN
        Assertions.assertNotNull(deadLine);
        verify(productRepository, times(1)).getProduct(uuid);
        verifyNoMoreInteractions(productRepository);
        assertEquals(productDomainExpected.getDeadLine(), deadLine);
    }

    @Test
    void shouldAddNewProductModel() {
        //GIVEN
        ProductDomain productDomain = getProductDomainMock();
        doNothing().when(productRepository).save(any());

        //WHEN
        productService.save(productDomain);

        //THEN
        verify(productRepository, times(1)).save(productDomain);
        verifyNoMoreInteractions(productRepository);
    }

    @Test
    void shouldDeleteAllProducts() {
        //GIVEN
        String uuid = getProductDomainMock().getId().toString();
        doNothing().when(productRepository).remove(any());

        //WHEN
        productService.remove(uuid);

        //THEN
        verify(productRepository, times(1)).remove(UUID.fromString(uuid));
        verifyNoMoreInteractions(productRepository);
    }

    @Test
    void shouldDeleteSpecificProduct() {
        //GIVEN
        String uuid = getProductDomainMock().getId().toString();
        doNothing().when(productRepository).remove(any());

        //WHEN
        productService.remove(uuid);

        //THEN
        verify(productRepository, times(1)).remove(UUID.fromString(uuid));
        verifyNoMoreInteractions(productRepository);
    }

    @Test
    void shouldUpdateProduct() throws Exception {
        //GIVEN
        ProductDomain productDomain = getProductDomainMock();
        doNothing().when(productRepository).updateProducts(any(), any());

        //WHEN
        productService.updateProducts(productDomain.getId().toString(), productDomain);

        //THEN
        verify(productRepository, times(1)).updateProducts(productDomain.getId(), productDomain);
        verifyNoMoreInteractions(productRepository);
    }

    @Test
    void shouldUpdatePriceProduct() throws Exception {
        //GIVEN
        ProductDomain productDomainOld = getProductDomainMock();
        when(productRepository.getProduct(productDomainOld.getId()))
                .thenReturn(productDomainOld);

        doNothing().when(productRepository).updateProducts(any(), any());

        Double newPrice = Double.valueOf(290000);
        productDomainOld.setPrice(newPrice);

        //WHEN
        productService.updateProductPrice(productDomainOld.getId().toString(), newPrice);

        //THEN
        verify(productRepository, times(1)).getProduct(productDomainOld.getId());
        verify(productRepository, times(1)).updateProducts(productDomainOld.getId(), productDomainOld);
        verifyNoMoreInteractions(productRepository);
    }
}
