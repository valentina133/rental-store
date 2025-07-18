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
    public City findById(Integer id) {
        Optional<City> byId = cityRepository.findById(id);
        City city = byId.get();
        return city;
    }

    //Inserisci
    public void inserisci(City city) {
        cityRepository.save(city);
    }

    //Aggiorna
    public void update(Integer id, City city) {
        Optional <City> cityOpt = cityRepository.findById(id);
        String newName=city.getName();
        cityOpt.get().setName(newName);
        //Country country= city.getCountry();
        //Integer newCountryId=country.getId();
        //Country countryByOpt=cityOpt.get().getCountry();
        //countryByOpt.setId(newCountryId);
        //cityOpt.get().setCountry(countryByOpt);
        cityRepository.save(cityOpt.get());
    }

    //Elimina
    public void deleteById(Integer id) {
        cityRepository.deleteById(id);
    }
}