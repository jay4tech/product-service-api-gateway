package com.example.product.service;

import com.example.product.entity.Product;
import com.example.product.entity.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteProduct(Long id) {
         productRepository.deleteById(id);
    }

    @Override
    public Product updateProduct(Product product) {
        Optional<Product> optionalProduct = productRepository.findById(product.getId());
        if(optionalProduct.isPresent()){
            product.setId(optionalProduct.get().getId());
            productRepository.save(product);
        }
        return product;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
}
