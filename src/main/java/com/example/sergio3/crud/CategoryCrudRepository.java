package com.example.sergio3.crud;


import com.example.sergio3.model.Category;
import org.springframework.data.repository.CrudRepository;


public interface CategoryCrudRepository extends CrudRepository<Category, Integer> {
}
