package com.example.store_server.service;

import com.example.store_server.model.Category;
import com.example.store_server.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Optional;

@Service
public class CategoryDao {
    @Autowired
    private CategoryRepo categoryRepo;


    public Iterable<Category> getAllCategory(String sortBy, String sortDir) {
        try {
            Sort sort = (sortDir.equalsIgnoreCase("desc"))?(Sort.by(sortBy).descending()):(Sort.by(sortBy).ascending());
            return categoryRepo.findAll(sort);
        } catch (Exception e) {
            // Handle the exception
            e.printStackTrace(); // You can log the exception or handle it in a different way
            throw new RuntimeException("An error occurred while fetching getAllCategory.");
        }
    }

    public Optional<Category> getCategoryById(Integer id) {
        try {
            System.out.println("db accessed");
            return categoryRepo.findById(id);
        } catch (Exception e) {
            // Handle the exception
            e.printStackTrace(); // You can log the exception or handle it in a different way
            throw new RuntimeException("An error occurred while fetching getCategoryById.");
        }
    }

    public Category addCategory(Category category) {
        try {
            return categoryRepo.save(category);
        } catch (Exception e) {
            // Handle other unexpected exceptions
            e.printStackTrace();
            throw new RuntimeException("An unexpected error occurred while adding the category.", e);
        }
    }
}
