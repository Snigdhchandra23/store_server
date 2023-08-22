package com.example.store_server.controller;

import com.example.store_server.model.Product;
import com.example.store_server.model.ProductVariant;
import com.example.store_server.service.ProductVariantDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ProductVariantController {

    @Autowired
    private ProductVariantDao productVariantDao;
    @GetMapping("/products/{product_id}/variants")
    public Iterable<ProductVariant> getAllVariantsByProductId(
            @PathVariable Integer product_id,
            @RequestParam(value = "sortBy", defaultValue = "price",required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = "asc",required = false) String sortDir)
    {
        return  productVariantDao.getAllVariantsByProductId(product_id,sortBy,sortDir);
    }

    @GetMapping("/allProducts")
    @Cacheable(value = "allProducts")
    public Iterable<ProductVariant> getAllProducts(
            @RequestParam(value = "sortBy", defaultValue = "name",required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = "asc",required = false) String sortDir
    ){
        return productVariantDao.getAllProducts(sortBy,sortDir);
    }

    @PutMapping("/products/variants/{sku}")
    @Cacheable(value = "variants" , key ="#sku")
    public Optional<ProductVariant> getProductVariantById(@PathVariable Integer sku){
        return productVariantDao.getProductVariantById(sku);
    }

    @PostMapping("/addProductVariant")
    public ProductVariant addProductVariant(@RequestBody ProductVariant pV){
        return productVariantDao.addProductVariant(pV);
    }

    @DeleteMapping("/deleteProductVariant/{sku}")
    public String deleteProductVariant(@PathVariable Integer sku){
        try {
            productVariantDao.deleteProductVariant(sku);
            return "Delete initiated for product variant with SKU " + sku ;
        } catch (Exception e) {
            return "An error occurred while initiating delete for the product variant with SKU " + sku + ": " + e.getMessage();
        }
    }

    //search product implementation

}
