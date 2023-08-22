package com.example.store_server.repository;

import com.example.store_server.model.Category;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends CrudRepository<Category,Integer> {

    Iterable<Category> findAll(Sort sort);
}
