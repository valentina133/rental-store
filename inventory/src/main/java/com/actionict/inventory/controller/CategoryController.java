package com.actionict.inventory.controller;

import com.actionict.inventory.model.Category;
import com.actionict.inventory.request.CategoryRequest;
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
    public void addCategory(@RequestBody CategoryRequest categoryRequest) {
        categoryService.inserisci(categoryRequest);
    }

    //aggiorna
    @PutMapping("/{id}")
    public void updateCategory(@PathVariable Integer id, @RequestBody CategoryRequest categoryRequest){
        categoryService.update(id, categoryRequest);
    }

    //Elimina
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Integer id){
        categoryService.deleteById(id);
    }
}