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

    //Dubbio: lastUpdate non lo metto tra i parametri
    //Inserisci
    public void inserisci(Integer id, String name) {
        Country country=new Country (id, name);
        countryRepository.save(country);
    }

    //Dubbio: lastUpdate non lo metto tra i parametri
    //Aggiorna
    public void update(Integer id, String newName) {
        Country country=countryRepository.findById(id);
        country.setName(newName);
        countryRepository.save(country);
    }

    //Elimina
    public void deleteById(Integer id) { countryRepository.deleteById(id); }
}