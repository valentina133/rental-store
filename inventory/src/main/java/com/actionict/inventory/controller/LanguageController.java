package com.actionict.inventory.controller;

import com.actionict.inventory.model.Language;
import com.actionict.inventory.request.LanguageRequest;
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
    public void addLanguage(@RequestBody LanguageRequest languageRequest) {
        languageService.inserisci(languageRequest);
    }

    //aggiorna
    @PutMapping("/{id}")
    public void updateLanguage(@PathVariable Integer id, @RequestBody LanguageRequest languageRequest){
        languageService.update(id, languageRequest);
    }

    //Elimina
    @DeleteMapping("/{id}")
    public void deleteLanguage(@PathVariable Integer id){
        languageService.deleteById(id);
    }
}