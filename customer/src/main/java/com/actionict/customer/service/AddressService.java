package com.actionict.customer.service;

import com.actionict.customer.model.Address;
import com.actionict.customer.model.City;
import com.actionict.customer.model.Country;
import com.actionict.customer.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;

    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    //Trova Uno
    public Address findById(Integer id) {
        return addressRepository.findById(id).orElseThrow(() -> new RuntimeException("Indirizzo non trovato:"+id));
    }

    //Inserisci
    public void inserisci(Address address) {
        addressRepository.save(address);
    }

    //Aggiorna
    public void update(Integer id, Address address) {
        Address addressByDB = addressRepository.findById(id).orElseThrow(() -> new RuntimeException("Indirizzo non trovato:"+id));
        String newAddress=address.getAddress();
        String newAddress2=address.getAddress2();
        String newDistrict=address.getDistrict();
        String newPostalCode=address.getPostalCode();
        String newPhone=address.getPhone();
        City city=address.getCity();  //Chiave esterna
        addressByDB.setAddress(newAddress);
        addressByDB.setAddress2(newAddress2);
        addressByDB.setDistrict(newDistrict);
        addressByDB.setPostalCode(newPostalCode);
        addressByDB.setPhone(newPhone);
        addressByDB.setCity(city);     //Chiave esterna
        addressRepository.save(addressByDB);
    }

    //Elimina
    public void deleteById (Integer id){
            addressRepository.deleteById(id);
        }
    }