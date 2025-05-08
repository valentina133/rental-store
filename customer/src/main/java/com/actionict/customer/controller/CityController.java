package com.actionict.customer.controller;

import com.actionict.customer.model.City;
import com.actionict.customer.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<City> getCity(@PathVariable Integer id){
        return cityService.findById(id);
    }

    //inserisci
    @PostMapping
    public void addCity(@RequestBody City city) {
        cityService.inserisci(city);
    }

    //aggiorna ok
    @PutMapping
    public void updateCity(@RequestBody City city){
        cityService.update(city);
    }
    /*@PutMapping("/{id}")  //?  ToDo
    public void updateCity(@RequestBody City city, @PathVariable Integer id){
        cityService.update(city);
    }
*/
    //Elimina ok
    @DeleteMapping("/{id}")
    public void deleteCity(@PathVariable Integer id){
        cityService.deleteById(id);
    }
}