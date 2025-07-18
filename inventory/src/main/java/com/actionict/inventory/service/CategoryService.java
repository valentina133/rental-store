package com.actionict.inventory.service;

import com.actionict.inventory.model.Actor;
import com.actionict.inventory.model.Category;
import com.actionict.inventory.repository.CategoryRepository;
import com.actionict.inventory.request.CategoryRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    //Trova Uno
    public Category findById(Integer id) {
        Optional<Category> byId = categoryRepository.findById(id);
        Category category = byId.get();
        return category;
    }

    //Inserisci
    public void inserisci(CategoryRequest categoryRequest) {
        String name=categoryRequest.getName();
        Category category = new Category();
        category.setName(name);
        categoryRepository.save(category);
    }

    //Aggiorna
    public void update(Integer id, CategoryRequest categoryRequest) {
        Optional<Category> categoryOpt = categoryRepository.findById(id);
        String newName=categoryRequest.getName();
        categoryOpt.get().setName(newName);
        categoryRepository.save(categoryOpt.get());
    }

    //Elimina
    public void deleteById(Integer id) {
        categoryRepository.deleteById(id);
    }
}