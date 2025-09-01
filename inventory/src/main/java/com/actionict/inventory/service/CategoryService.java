package com.actionict.inventory.service;

import com.actionict.inventory.model.Category;
import com.actionict.inventory.repository.CategoryRepository;
import com.actionict.inventory.request.CategoryRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor

public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    //Trova Uno
    public Category findById(Integer id) {
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Categoria non trovata:"+id));
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
        Category categoryByDB = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Categoria non trovata:"+id));
        String newName=categoryRequest.getName();
        categoryByDB.setName(newName);
        categoryRepository.save(categoryByDB);
    }

    //Elimina
    public void deleteById(Integer id) {
        categoryRepository.deleteById(id);
    }
}