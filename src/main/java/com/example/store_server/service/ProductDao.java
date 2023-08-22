package com.example.store_server.service;

import com.example.store_server.model.Product;
import com.example.store_server.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductDao {
    @Autowired
    private ProductRepo productRepo;
    public Iterable<Product> getProduct(String sortBy, String sortDir) {
        try {
            // Create a Sort object based on the provided sortBy and sortDir
            Sort sort = (sortDir.equalsIgnoreCase("desc"))?(Sort.by(sortBy).descending()):(Sort.by(sortBy).ascending());
//            Sort sort = Sort.by(Sort.Direction.fromString(sortDir), sortBy);

            // Use the sort object in the findAll() method to fetch products with sorting
            return productRepo.findAll(sort);
        } catch (Exception e) {
            // You can log the exception for debugging purposes
            e.printStackTrace();
            // You can also throw a custom exception or return a specific result here
            throw new RuntimeException("Error while fetching getProducts: " + e.getMessage());
        }
    }

    public Optional<Product> getProductById(Integer id) {
        try {
            return productRepo.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error while fetching product with ID " + id + ": " + e.getMessage());
        }
    }

    public Product addProduct(Product product) {
        try {
            return productRepo.save(product);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error while adding product: " + e.getMessage());
        }
    }

}
