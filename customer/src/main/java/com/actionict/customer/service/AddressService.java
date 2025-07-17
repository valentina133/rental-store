package com.actionict.customer.service;

import com.actionict.customer.model.Address;
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
    public Address findById(Integer id) {

        Optional<Address> byId = addressRepository.findById(id);
        Address address = byId.get();
        return address;
    }

    //Inserisci
    public void inserisci(Address address) {
        addressRepository.save(address);
    }

    //Aggiorna
    public void update(Integer id, Address address) {
        Optional<Address> addressOpt = addressRepository.findById(id);
        String newAddress=address.getAddress();
        String newAddress2=address.getAddress2();
        String newDistrict=address.getDistrict();
        String newPostalCode=address.getPostalCode();
        String newPhone=address.getPhone();
        //City city=address.getCity();
        //Integer newCityId=city.getId();
        addressOpt.get().setAddress(newAddress);
        addressOpt.get().setAddress2(newAddress2);
        addressOpt.get().setDistrict(newDistrict);
        addressOpt.get().setPostalCode(newPostalCode);
        addressOpt.get().setPhone(newPhone);
        //City cityByOpt=addressOpt.get().getCity();
        //cityByOpt.setId(newCityId);
        //addressOpt.get().setCity(cityByOpt);
        addressRepository.save(addressOpt.get());
    }

    //Elimina
    public void deleteById (Integer id){
            addressRepository.deleteById(id);
        }
    }