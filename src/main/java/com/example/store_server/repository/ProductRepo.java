package com.example.store_server.repository;

import com.example.store_server.model.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends CrudRepository<Product,Integer> {
    List<Product> findByCategory_id(Integer keywords);

    Iterable<Product> findAll(Sort sort);
}
