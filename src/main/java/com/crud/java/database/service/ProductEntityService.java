package com.crud.java.database.service;

import com.crud.java.core.model.Product;
import com.crud.java.core.port.ProductEntityServicePort;
import com.crud.java.database.entity.ProductEntity;
import com.crud.java.database.repository.ProductEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductEntityService implements ProductEntityServicePort {

    @Autowired
    private ProductEntityRepository productEntityRepository;

    @Override
    public List<Product> findAll() {
        return productEntityRepository.findAll().stream().map(entity -> new Product(
                entity.getId(),entity.getName(),entity.getPrice(),entity.getDescription()
        )).collect(Collectors.toList());
    }

    @Override
    public Product saveProductEntity(ProductEntity productEntity) {
        var productRepository = productEntityRepository.save(productEntity);

        return new Product(productRepository.getId(),productRepository.getName(),productRepository.getPrice(),
                productRepository.getDescription());
    }

    @Override
    public void deleteProduct(Long id) {
        productEntityRepository.deleteById(id);
    }
}
