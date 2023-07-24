package com.example.springdatajpa.service;

import com.example.springdatajpa.model.Product;

import java.util.List;

public interface ProductService {
    public List<Product> findAll();
    public Product save(Product product);
    public void delete(Long Id);
    public Product findById(Long id);
}
