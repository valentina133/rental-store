package com.actionict.customer.controller;

import com.actionict.customer.model.Customer;
import com.actionict.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.findAll();
    }

    //trova uno
    @GetMapping("/{id}")
    public Customer getCustomers(@PathVariable Integer id){
        return customerService.findById(id);
    }

    //inserisci
    @PostMapping
    public void addCustomer(@RequestBody Customer customer) {
        customerService.inserisci(customer);
    }

    //aggiorna
    @PutMapping("/{id}")
    public void updateCustomer(@PathVariable Integer id, @RequestBody Customer customer){
        customerService.update(id, customer);
    }

    //Elimina
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Integer id){
        customerService.deleteById(id);
    }

    //Discerne tra le due getMapping aggiungendo all'endpoint la coppia chiave-valore
    //Ricerca filtrata e paginata
    @GetMapping("?firstName=mario||lastName=Rossi")
    public Page<Customer> getFilterPaginatedCustomers(
            @RequestParam (required = false) String firstName,
            @RequestParam (required = false) String lastName,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){

        return customerService.searchFilterPaginatedCustomers(firstName, lastName, page, size);
    }
}