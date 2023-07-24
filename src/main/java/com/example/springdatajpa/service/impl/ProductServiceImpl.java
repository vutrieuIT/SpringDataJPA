package com.example.springdatajpa.service.impl;

import com.example.springdatajpa.model.Product;
import com.example.springdatajpa.repository.ProductRepository;
import com.example.springdatajpa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void delete(Long Id) {
        productRepository.deleteById(Id);
    }

    @Override
    public Product findById(Long Id) {
        return productRepository.findById(Id).orElse(null);
    }
}
