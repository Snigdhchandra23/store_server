package com.example.store_server.service;

import com.example.store_server.model.ProductVariant;
import com.example.store_server.repository.ProductVariantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductVariantDao {
    @Autowired
    private ProductVariantRepo productVariantRepo;

    public Iterable<ProductVariant> getAllProducts(String sortBy, String sortDir) {
        try {
            // Create a Sort object based on the provided sortBy and sortDir
            Sort sort = (sortDir.equalsIgnoreCase("desc"))?(Sort.by(sortBy).descending()):(Sort.by(sortBy).ascending());
            System.out.println("db accessed");
            // Use the sort object in the findAll() method to fetch products with sorting
            return productVariantRepo.findAll(sort);
        } catch (Exception e) {
            // You can log the exception for debugging purposes
            e.printStackTrace();
            // You can also throw a custom exception or return a specific result here
            throw new RuntimeException("Error while fetching getAllProducts: " + e.getMessage());
        }
    }

    public Optional<ProductVariant> getProductVariantById(Integer sku) {
        try {
            System.out.println("db accessed");
            return productVariantRepo.findById(sku);
        } catch (Exception e) {
            // You can log the exception for debugging purposes
            e.printStackTrace();
            // You can also throw a custom exception or return a specific result here
            throw new RuntimeException("Error while fetching product variant with SKU " + sku + ": " + e.getMessage());
        }
    }

    public Iterable<ProductVariant> getAllVariantsByProductId(Integer product_id,String sortBy,String sortDir) {
        try {
            Sort sort = Sort.by(Sort.Direction.fromString(sortDir), sortBy);
            return productVariantRepo.findByProduct_id(product_id,sort);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error while fetching variants for product with ID " + product_id + ": " + e.getMessage());
        }
    }

    public ProductVariant addProductVariant(ProductVariant pV) {
        try {
            return productVariantRepo.save(pV);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error while adding product variant: " + e.getMessage());
        }    }

    public String deleteProductVariant(Integer sku) {
//        productVariantRepo.deleteById(sku);
        try {
            productVariantRepo.deleteById(sku);
            return "Product variant with SKU " + sku + " has been deleted.";
        } catch (Exception e) {
            return "An error occurred while deleting the product variant with SKU " + sku + ": " + e.getMessage();
        }

    }


}
