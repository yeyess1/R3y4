package com.example.sergio3.services;

import com.example.sergio3.crud.CategoryRepository;
import com.example.sergio3.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServices {
    @Autowired
        private CategoryRepository categoryCrudRepository;

        public List<Category> getAll() {
            return categoryCrudRepository.getAll();
        }

        public Optional<Category> getCategory(int CategoriaId) {return categoryCrudRepository.getCategory(CategoriaId);}

        public Category save(Category categoria) {
            if (categoria.getId()== null) {
                return  categoryCrudRepository.save(categoria);
            } else {
                Optional<Category> category = categoryCrudRepository.getCategory(categoria.getId());
                if (category.isEmpty()) {
                    return categoryCrudRepository.save(categoria);
                } else {
                    return categoria;
                }
            }
        }

        public Category update(Category categoria){
            if(categoria.getId()!=null){
                Optional<Category>g=categoryCrudRepository.getCategory(categoria.getId());
                if(!g.isEmpty()){
                    if(categoria.getDescription()!=null){
                        g.get().setDescription(categoria.getDescription());
                    }
                    if(categoria.getName()!=null){
                        g.get().setName(categoria.getName());
                    }
                    return categoryCrudRepository.save(g.get());
                }
            }
            return categoria;
        }
        public boolean deletecategory(int categoriaId){
            Boolean d=getCategory(categoriaId).map(categoria -> {
                categoryCrudRepository.delete(categoria);
                return true;
            }).orElse(false);
            return d;
        }

}


