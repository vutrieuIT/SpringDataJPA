package com.example.springdatajpa.repository;

import com.example.springdatajpa.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByNameContaining(String keyword);

    List<Product> findByPriceGreaterThan(Double price);

    List<Product> findFirst5ByOrderByPriceAsc();
}
