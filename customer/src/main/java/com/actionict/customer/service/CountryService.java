package com.actionict.customer.service;

import com.actionict.customer.model.Country;
import com.actionict.customer.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class CountryService {

    private final CountryRepository countryRepository;

    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    //Trova Uno
    public Country findById(Integer id) {
        Optional<Country> byId = countryRepository.findById(id);
        Country country = byId.get();
        return country;
    }

    //Inserisci
    public void inserisci(Country country) {
        countryRepository.save(country);
    }

    //Aggiorna
    public void update(Integer id, Country country) {
        Optional<Country> countryOpt = countryRepository.findById(id);
        String newName=country.getName();
        countryOpt.get().setName(newName);
        countryRepository.save(countryOpt.get());
    }

    //Elimina
    public void deleteById(Integer id) {
        countryRepository.deleteById(id);
    }
}