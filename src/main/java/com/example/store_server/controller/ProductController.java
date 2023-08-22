package com.example.store_server.controller;

import com.example.store_server.model.Category;
import com.example.store_server.model.Product;
import com.example.store_server.service.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    private ProductDao productDao;

    @GetMapping("/products")
    public Iterable<Product> getProduct(
            @RequestParam(value = "sortBy", defaultValue = "name",required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = "asc",required = false) String sortDir
    ){
        return productDao.getProduct(sortBy,sortDir);
    }

    @PutMapping("/products/{id}")
    @Cacheable(value = "products" , key ="#id")
    public Optional<Product> getProductById(@PathVariable Integer id){
        return productDao.getProductById(id);
    }

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        return productDao.addProduct(product);
    }


}
