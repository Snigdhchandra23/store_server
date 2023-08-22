package com.example.store_server.repository;

import com.example.store_server.model.ProductVariant;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductVariantRepo extends CrudRepository<ProductVariant,Integer> {
    Iterable<ProductVariant> findAll(Sort sort);
    List<ProductVariant> findByProduct_id(Integer keyword, Sort sort);


}
