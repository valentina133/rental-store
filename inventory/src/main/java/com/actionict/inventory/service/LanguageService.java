package com.actionict.inventory.service;

import com.actionict.inventory.model.Language;
import com.actionict.inventory.repository.LanguageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class LanguageService {

    private final LanguageRepository languageRepository;

    public List<Language> findAll() {
        return languageRepository.findAll();
    }

    //Trova Uno
    public Language findById(Integer id) {
        Optional<Language> byId = languageRepository.findById(id);
        Language language = byId.get();
        return language;
    }

    //Inserisci
    public void inserisci(String name) {
        Language language = new Language();
        language.setName(name);
        languageRepository.save(language);
    }

    //Aggiorna
    public void update(Integer id, String newName) {
        Optional<Language> language = languageRepository.findById(id);
        language.get().setName(newName);
        languageRepository.save(language.get());
    }

    //Elimina
    public void deleteById(Integer id) {
        languageRepository.deleteById(id);
    }
}