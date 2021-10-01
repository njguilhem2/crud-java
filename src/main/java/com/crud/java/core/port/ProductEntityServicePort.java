package com.crud.java.core.port;

import com.crud.java.core.model.Product;
import com.crud.java.database.entity.ProductEntity;

import java.util.List;

public interface ProductEntityServicePort {
    List<Product> findAll();
    Product saveProductEntity(ProductEntity productEntity);
    void deleteProduct(Long id);
}
