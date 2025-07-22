package com.actionict.customer.service;

import com.actionict.customer.model.Country;
import com.actionict.customer.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor

public class CountryService {

    private final CountryRepository countryRepository;

    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    //Trova Uno
    public Country findById(Integer id) {
        return countryRepository.findById(id).orElseThrow(() -> new RuntimeException("Paese non trovato:"+id));
    }

    //Inserisci
    public void inserisci(Country country) {
        countryRepository.save(country);
    }

    //Aggiorna
    public void update(Integer id, Country country) {
        Country countryByDB = countryRepository.findById(id).orElseThrow(() -> new RuntimeException("Paese non trovato:"+id));
        String newName=country.getName();
        country.setName(newName);
        countryRepository.save(countryByDB);
    }

    //Elimina
    public void deleteById(Integer id) {
        countryRepository.deleteById(id);
    }
}