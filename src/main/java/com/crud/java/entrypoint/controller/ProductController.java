package com.crud.java.entrypoint.controller;

import com.crud.java.core.model.Product;
import com.crud.java.core.port.ProductServicePort;
import com.crud.java.entrypoint.dto.ProductDto;
import com.crud.java.entrypoint.utils.ProductUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @GetMapping
    public ResponseEntity<?> getAllProduct(){
        return new ResponseEntity(productServicePort.findAllProduct(),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){
        productServicePort.deleteProduct(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
