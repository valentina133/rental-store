package com.actionict.inventory.controller;

import com.actionict.inventory.model.Category;
import com.actionict.inventory.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<Category> getAllCategories() {return categoryService.findAll();}

    //trova uno
    @GetMapping("/{id}")
    public Category getCategory(@PathVariable Integer id){
        return categoryService.findById(id);
    }

    //inserisci
    @PostMapping
    public void addCategory(@RequestBody Category category) {
        String name=category.getName();
        categoryService.inserisci(name);
    }

    //aggiorna
    @PutMapping
    public void updateCategory(@RequestBody Category category){
        Integer id=category.getId();
        String name=category.getName();
        categoryService.update(id, name);
    }

    //Elimina
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Integer id){
        categoryService.deleteById(id);
    }
}