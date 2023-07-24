package com.example.springdatajpa.controller;

import com.example.springdatajpa.model.Product;
import com.example.springdatajpa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @GetMapping("")
    public List<Product> getAll(){
        List<Product> products = productService.findAll();
        return products;
    }

    @PostMapping("/save")
    public Product save(@RequestBody Product product){
        return productService.save(product);
    }

    @GetMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam Long id){
        System.out.println(id);
        productService.delete(id);
        return ResponseEntity.ok("deleted product");
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id){
        return productService.findById(id);
    }
}
