package com.actionict.inventory.controller;

import com.actionict.inventory.model.Language;
import com.actionict.inventory.service.LanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/languages")
@RequiredArgsConstructor
public class LanguageController {

    private final LanguageService languageService;

    @GetMapping
    public List<Language> getAllLanguages() {return languageService.findAll();}

    //trova uno
    @GetMapping("/{id}")
    public Language getLanguage(@PathVariable Integer id){
        return languageService.findById(id);
    }

    //inserisci
    @PostMapping
    public void addLanguage(@RequestBody Language language) {
        String name=language.getName();
        languageService.inserisci(name);
    }

    //aggiorna
    @PutMapping
    public void updateLanguage(@RequestBody Language language){
        Integer id=language.getId();
        String name=language.getName();
        languageService.update(id, name);
    }

    //Elimina
    @DeleteMapping("/{id}")
    public void deleteLanguage(@PathVariable Integer id){
        languageService.deleteById(id);
    }
}