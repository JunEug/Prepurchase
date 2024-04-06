package org.example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.product.Product;
import org.example.model.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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

    @Transactional
    public Product updateProduct(Long id, Product updatedProduct) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found with id: " + id));

        existingProduct.setName(updatedProduct.getName());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setSale(updatedProduct.getSale());
        existingProduct.setDescription(updatedProduct.getDescription());
        existingProduct.setDestinationTime(updatedProduct.getDestinationTime());
        existingProduct.setWaysToDelivery(updatedProduct.getWaysToDelivery());
        existingProduct.setDeliveryPrice(updatedProduct.getDeliveryPrice());
        existingProduct.setWaysToPay(updatedProduct.getWaysToPay());
        existingProduct.setPolitics(updatedProduct.getPolitics());
        existingProduct.setProductImageUrl(updatedProduct.getProductImageUrl());

        return productRepository.save(existingProduct);
    }

    @Transactional
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
