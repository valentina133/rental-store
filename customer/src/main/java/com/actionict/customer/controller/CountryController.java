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
    public Country getCountries(@PathVariable Integer id){
        return countryService.findById(id);
    }

    //inserisci
    @PostMapping
    public void addCountry(@RequestBody Country country) {
        countryService.inserisci(country);
    }

    //aggiorna
    @PutMapping("/{id}")
    public void updateCountry(@PathVariable Integer id, @RequestBody Country country){
        countryService.update(id, country);
    }

    //Elimina
    @DeleteMapping("/{id}")
    public void deleteCountry(@PathVariable Integer id){
        countryService.deleteById(id);
    }
}