package com.actionict.customer.controller;

import com.actionict.customer.model.City;
import com.actionict.customer.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @GetMapping
    public List<City> getAllCities() {
        return cityService.findAll();
    }

    //trova uno
    @GetMapping("/{id}")
    public City getCity(@PathVariable Integer id){
        return cityService.findById(id);
    }

    //inserisci
    @PostMapping
    public void addCity(@RequestBody City city) {
        cityService.inserisci(city);
    }

    //aggiorna ok
    @PutMapping("/{id}")
    public void updateCity(@PathVariable Integer id, @RequestBody City city){
        cityService.update(id, city);
    }

    //Elimina ok
    @DeleteMapping("/{id}")
    public void deleteCity(@PathVariable Integer id){
        cityService.deleteById(id);
    }
}