package com.actionict.customer.controller;

import com.actionict.customer.model.Country;
import com.actionict.customer.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
@RequiredArgsConstructor
public class CountryController {

    private final CountryService countryService;

    @GetMapping
    public List<Country> getAllCountries() {return countryService.findAll();}

    //trova uno
    @GetMapping("/{id}")
    public Object getCountries(@PathVariable Integer id){
        return countryService.findById(id);
    }

    //inserisci
    @PostMapping
    public void addCountry(@RequestBody Country country) {
        Integer id=country.getId();
        String name=country.getName();
        countryService.inserisci(id, name);
    }

    //aggiorna
    @PutMapping
    public void updateCountry(@RequestBody Country country){
        Integer id=country.getId();
        String name=country.getName();
        countryService.update(id, name);
    }

    //Elimina
    @DeleteMapping("/{id}")
    public void deleteCountry(@PathVariable Integer id){
        countryService.deleteById(id);
    }



}