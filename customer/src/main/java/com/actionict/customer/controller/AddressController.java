package com.actionict.customer.controller;

import com.actionict.customer.model.Address;
import com.actionict.customer.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Address getAddresses(@PathVariable Integer id){
        return addressService.findById(id);
    }

    //inserisci
    @PostMapping
    public void addAddress(@RequestBody Address address) {
        addressService.inserisci(address);
    }

    //aggiorna
    @PutMapping("/{id}")
    public void updateAddress(@PathVariable Integer id, @RequestBody Address address){
        addressService.update(id, address);
    }


    //Elimina
    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable Integer id){
        addressService.deleteById(id);
    }
}