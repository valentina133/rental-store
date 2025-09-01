package com.actionict.inventory.service;

import com.actionict.inventory.model.Language;
import com.actionict.inventory.repository.LanguageRepository;
import com.actionict.inventory.request.LanguageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor

public class LanguageService {

    private final LanguageRepository languageRepository;

    public List<Language> findAll() {
        return languageRepository.findAll();
    }

    //Trova Uno
    public Language findById(Integer id) {
        return languageRepository.findById(id).orElseThrow(() -> new RuntimeException("Lingua non trovata:"+id));
    }

    //Inserisci
    public void inserisci(LanguageRequest languageRequest) {
        String name=languageRequest.getName();
        Language language = new Language();
        language.setName(name);
        languageRepository.save(language);
    }

    //Aggiorna
    public void update(Integer id, LanguageRequest languageRequest) {
        Language languageByDB = languageRepository.findById(id).orElseThrow(() -> new RuntimeException("Lingua non trovato:"+id));
        String newName=languageRequest.getName();
        languageByDB.setName(newName);
        languageRepository.save(languageByDB);
    }

    //Elimina
    public void deleteById(Integer id) {
        languageRepository.deleteById(id);
    }
}