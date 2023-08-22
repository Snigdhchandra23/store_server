package com.example.store_server.controller;

import com.example.store_server.model.Category;
import com.example.store_server.service.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping
public class CategoryController {


    @Autowired
    private CategoryDao categoryDao;

    @GetMapping("/category")
    public Iterable<Category> getAllCategory(
            @RequestParam(value = "sortBy", defaultValue = "name",required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = "asc",required = false) String sortDir
    ){
        return categoryDao.getAllCategory(sortBy,sortDir);
    }

    @PutMapping("/category/{id}")
    @Cacheable(value = "Category" , key ="#id")
    public Optional<Category> getCategoryById(@PathVariable Integer id){
        return categoryDao.getCategoryById(id);
    }

    @PostMapping("/addCategory")
    public Category addCategory(@RequestBody Category category){
        return categoryDao.addCategory(category);
    }


}
