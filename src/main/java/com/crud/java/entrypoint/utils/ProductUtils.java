package com.crud.java.entrypoint.utils;

import com.crud.java.entrypoint.dto.ProductDto;
import com.crud.java.entrypoint.handler.exception.GlobalException;
import org.springframework.util.ObjectUtils;

public class ProductUtils {
    public static ProductDto validatedProduct(ProductDto productDto){
        validatedName(productDto.getName());
        validatedPrice(productDto.getPrice());
        validatedDescription(productDto.getDescription());
        return productDto;
    }
    private static Boolean validatedName(String name){
        if (!ObjectUtils.isEmpty(name)){
            return true;
        }
        throw new GlobalException("Nome inválido");
    }
    private static Boolean validatedPrice(Double price){
        if (price > 0){
            return true;
        }
        throw new GlobalException("Preço tem que ser maior que Zero");
    }
    private static Boolean validatedDescription(String description){
        if (ObjectUtils.isArray(description)){
            return true;
        }
        throw new GlobalException("descrição não pode ser nula ou vazio");
    }
}
