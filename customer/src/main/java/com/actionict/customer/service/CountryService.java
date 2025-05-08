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

        return countryRepository.findById(id);
    }

    //Inserisci
    public void inserisci(String name) {
        Country country=new Country (name);
        countryRepository.save(country);
    }

    //Aggiorna
    public void Update(Integer id, String newName) {
        Country country=countryRepository.findById(id);
        country.setName(newName);
        countryRepository.save(country);
    }

    //Elimina
    public void deleteById(Integer id) { countryRepository.deleteById(id); }
}