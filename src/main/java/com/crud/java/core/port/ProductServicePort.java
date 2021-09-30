package com.crud.java.core.port;

import com.crud.java.core.model.Product;
import com.crud.java.entrypoint.dto.ProductDto;

import java.util.List;

public interface ProductServicePort {
    ProductDto saveProduct(Product product);
    List<ProductDto> findAllProduct();
    void deleteProduct(Long id);
}
