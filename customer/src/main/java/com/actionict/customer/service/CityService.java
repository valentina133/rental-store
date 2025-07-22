package com.actionict.customer.service;

import com.actionict.customer.model.City;
import com.actionict.customer.model.Country;
import com.actionict.customer.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;

    public List<City> findAll() {
        return cityRepository.findAll();
    }

    //Trova Uno
    public City findById(Integer id) {
        return cityRepository.findById(id).orElseThrow(() -> new RuntimeException("Città non trovata:"+id));
    }

    //Inserisci
    public void inserisci(City city) {
        cityRepository.save(city);
    }

    //Aggiorna
    public void update(Integer id, City city) {
        City cityByDB = cityRepository.findById(id).orElseThrow(() -> new RuntimeException("Città non trovato:"+id));
        String newName=city.getName();
        cityByDB.setName(newName);
        Country country= city.getCountry();   //chiave esterna
        Integer newCountryId=country.getId();   //chiave esterna
        Country countryByDB=cityByDB.getCountry();   //chiave esterna
        countryByDB.setId(newCountryId);   //chiave esterna
        cityByDB.setCountry(countryByDB);   //chiave esterna
        cityRepository.save(cityByDB);
    }

    //Elimina
    public void deleteById(Integer id) {
        cityRepository.deleteById(id);
    }
}