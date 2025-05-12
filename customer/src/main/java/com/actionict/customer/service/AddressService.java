package com.actionict.customer.service;

import com.actionict.customer.model.Address;
import com.actionict.customer.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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
        //return addressRepository.findById(id);
    }

    //Inserisci
    public void inserisci(Integer id, String address, String address2, String district, String postalCode, String phone) {
        Address addressOfInsert=new Address (id, address, address2, district, postalCode, phone);
        addressRepository.save(addressOfInsert);
    }

    //Aggiorna
    public void update(Integer id, String newAddress, String newAddress2, String newDistrict, String newPostalCode, String newPhone) {
        Optional<Address> address=addressRepository.findById(id);
        address.setAddress(newAddress);
        address.setAddress2(newAddress2);
        address.setDistrict(newDistrict);
        address.setPostalCode(newPostalCode);
        address.setPhone(newPhone);
        addressRepository.save(address);
    }

    //Elimina
    public void deleteById(Integer id) { addressRepository.deleteById(id); }
}