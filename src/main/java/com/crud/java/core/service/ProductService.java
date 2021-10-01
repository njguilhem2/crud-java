package com.crud.java.core.service;

import com.crud.java.core.model.Product;
import com.crud.java.core.port.ProductEntityServicePort;
import com.crud.java.core.port.ProductServicePort;
import com.crud.java.database.entity.ProductEntity;
import com.crud.java.entrypoint.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements ProductServicePort {

    @Autowired
    private ProductEntityServicePort productEntityServicePort;

    @Override
    public ProductDto saveProduct(Product product) {
        var productService = productEntityServicePort
                .saveProductEntity(new ProductEntity(product.getId(),product.getName(),
                product.getPrice(),product.getDescription()));
        return new ProductDto(productService.getId(),
                product.getName(),product.getPrice(),product.getDescription());
    }

    @Override
    public List<ProductDto> findAllProduct() {
        return productEntityServicePort.findAll().stream().map(product -> new ProductDto(
                product.getId(),product.getName(),product.getPrice(),product.getDescription()
        )).collect(Collectors.toList());
    }

    @Override
    public void deleteProduct(Long id) {
        productEntityServicePort.deleteProduct(id);
    }
}
