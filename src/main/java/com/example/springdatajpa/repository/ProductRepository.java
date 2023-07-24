package com.example.springdatajpa.repository;

import com.example.springdatajpa.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // query method
    List<Product> findByNameContaining(String keyword);

    List<Product> findByPriceGreaterThan(Double price);

    List<Product> findFirst5ByOrderByPriceAsc();

    // JPQL
    @Query("SELECT p FROM Product p WHERE p.name LIKE %:keyword%")
    List<Product> findProductByNameContaining(@Param("keyword") String keyword);

    @Query("SELECT p FROM Product p WHERE p.price > :price")
    List<Product> findProductByPriceGreaterThan(@Param("price") Double price);

    @Query("SELECT p FROM Product p WHERE p.price > :minPrice AND p.price < :maxPrice")
    List<Product> findProductByPriceBetween(@Param("minPrice") Double minPrice,
                                            @Param("maxPrice") Double maxPrice);
}
