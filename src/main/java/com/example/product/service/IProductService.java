package com.example.product.service;

import com.example.product.entity.Product;

public interface IProductService {
    Product getProduct(Long id);

    void deleteProduct(Long id);

    Product updateProduct(Product product);

    Product createProduct(Product product);
}
