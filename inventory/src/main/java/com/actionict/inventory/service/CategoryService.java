package com.actionict.inventory.service;
import com.actionict.inventory.model.Category;
import com.actionict.inventory.repository.CategoryRepository;
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
    public void inserisci(String name) {
        Category country = new Category();
        country.setName(name);
        categoryRepository.save(country);
    }

    //Aggiorna
    public void update(Integer id, String newName) {
        Optional<Category> country = categoryRepository.findById(id);
        country.get().setName(newName);
        categoryRepository.save(country.get());
    }

    //Elimina
    public void deleteById(Integer id) {
        categoryRepository.deleteById(id);
    }
}