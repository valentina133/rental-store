package com.actionict.customer.service;

import com.actionict.customer.model.City;
import com.actionict.customer.model.Country;
import com.actionict.customer.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    public Object findById(Integer id) {

        return countryRepository.findById(id);
    }

    //Inserisci
    public void inserisci(String name) {
        //public void inserisci(Integer id, String name) {
        Country country = new Country();
        //country.setId(id);   //Non serve perché c'è l'autoincrementante sul model @GeneratedValue(strategy = GenerationType.IDENTITY)
        country.setName(name);
        countryRepository.save(country);
    }

    //Aggiorna
    public void update(Integer id, String newName) {
        Optional<Country> country = countryRepository.findById(id);
        //country.get()
        country.get().setName(newName);
        countryRepository.save(country.get());
    }

    //Elimina
    public void deleteById(Integer id) {
        countryRepository.deleteById(id);
    }
}