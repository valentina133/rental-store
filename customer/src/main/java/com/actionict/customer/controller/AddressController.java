package com.actionict.customer.controller;

import com.actionict.customer.model.Address;
import com.actionict.customer.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/addresses")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @GetMapping
    public List<Address> getAllAddresses() {
        return addressService.findAll();
    }

    //trova uno
    @GetMapping("/{id}")
    public Object getAddresses(@PathVariable Integer id){
        return addressService.findById(id);
    }

    //inserisci
    @PostMapping
    public void addAddress(@RequestBody Address address) {
        //Integer id=address.getId();
        String addressParametro= address.getAddress();
        String address2= address.getAddress2();
        String district= address.getDistrict();
        String postalCode= address.getPostalCode();
        String phone= address.getPhone();
        addressService.inserisci(addressParametro, address2, district, postalCode, phone);
    }

    //aggiorna
    @PutMapping
    public void updateAddress(@RequestBody Address address){
        Integer id= address.getId();
        String addressParametro=address.getAddress();
        String address2=address.getDistrict();
        String district=address.getDistrict();
        String postalCode=address.getPostalCode();
        String phone=address.getPhone();
        addressService.update(id, addressParametro, address2, district, postalCode, phone);
    }


    //Elimina
    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable Integer id){
        addressService.deleteById(id);
    }
}