package com.crud.java.core.port;

import com.crud.java.core.model.Product;
import com.crud.java.database.entity.ProductEntity;

public interface ProductEntityServicePort {

    Product saveProductEntity(ProductEntity productEntity);
}
