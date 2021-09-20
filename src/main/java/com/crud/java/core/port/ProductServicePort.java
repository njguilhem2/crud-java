package com.crud.java.core.port;

import com.crud.java.core.model.Product;
import com.crud.java.entrypoint.dto.ProductDto;

public interface ProductServicePort {
    ProductDto saveProduct(Product product);
}
