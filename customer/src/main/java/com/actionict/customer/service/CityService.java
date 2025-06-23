package com.actionict.customer.service;

import com.actionict.customer.model.City;
import com.actionict.customer.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;

    public List<City> findAll() {
        return cityRepository.findAll();
    }

    //Trova Uno
    public Object findById(Integer id) {

        return cityRepository.findById(id);
    }

    //Inserisci
    public void inserisci(Integer id, String name) {
        City city = new City();
        //city.setId(id);
        city.setName(name);
        cityRepository.save(city);
    }

    //Aggiorna
    public void update(Integer id, String newName) {
        Optional <City> city = cityRepository.findById(id);
        //City city = (City) cityObject;
        //city.setName(newName);
        city.get().setName(newName);
        cityRepository.save(city.get());
    }

    //Elimina
     public void deleteById(Integer id) {
        cityRepository.deleteById(id);
    }
}