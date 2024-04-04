package org.example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Product;
import org.example.model.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public ProductService(ProductRepository productRepository, ObjectMapper objectMapper) {
        this.productRepository = productRepository;
        this.objectMapper = objectMapper;
    }


    public void createProduct(Product product) {
        productRepository.save(product);
    }


    public Product getProductById(Long id) {
        return productRepository.findByProductId(id);
    }

}
