package com.crud.java.entrypoint.controller;

import com.crud.java.core.model.Product;
import com.crud.java.core.port.ProductServicePort;
import com.crud.java.entrypoint.dto.ProductDto;
import com.crud.java.entrypoint.utils.ProductUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    private ProductServicePort productServicePort;

    @PostMapping
    public ResponseEntity<ProductDto> postProduct(@RequestBody ProductDto product){
        ProductUtils.validatedProduct(product);
        return new ResponseEntity(
                productServicePort.saveProduct(new Product(product.getId(),product.getName()
                        ,product.getPrice(),product.getDescription()))
                , HttpStatus.CREATED);
    }
}
