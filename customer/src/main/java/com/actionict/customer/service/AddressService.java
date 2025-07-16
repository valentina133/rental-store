package com.actionict.customer.service;

import com.actionict.customer.model.Address;
import com.actionict.customer.model.City;
import com.actionict.customer.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;

    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    //Trova Uno
    public Object findById(Integer id) {

        Optional<Address> byId = addressRepository.findById(id);
        return byId;
    }

    //Inserisci
    public void inserisci(String address, String address2, String district, String postalCode, String phone, Integer id) {
        Address addressOfInsert=new Address();
        addressOfInsert.setAddress(address);
        addressOfInsert.setAddress2(address2);
        addressOfInsert.setDistrict(district);
        addressOfInsert.setPostalCode(postalCode);
        addressOfInsert.setPhone(phone);
        City city = new City();
        city.setId(id);
        addressOfInsert.setCity(city);
        addressRepository.save(addressOfInsert);
    }

    //Aggiorna
    public void update(Integer id, String newAddress, String newAddress2, String newDistrict, String newPostalCode, String newPhone) {
        Optional<Address> address = addressRepository.findById(id);
        address.get().setAddress(newAddress);
        address.get().setAddress2(newAddress2);
        address.get().setDistrict(newDistrict);
        address.get().setPostalCode(newPostalCode);
        address.get().setPhone(newPhone);
        addressRepository.save(address.get());
    }

    //Elimina
    public void deleteById (Integer id){
            addressRepository.deleteById(id);
        }
    }