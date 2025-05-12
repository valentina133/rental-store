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
import java.util.Objects;
//import javax.validation.constraints.Size;
@Validated
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
    public Object getCustomers(@PathVariable Integer id){
        return customerService.findById(id);
    }

    //inserisci
    @PostMapping
    public void addCustomer(@RequestBody Customer customer) {
        customerService.inserisci(customer);
    }

    //aggiorna
    @PutMapping
    public void updateCustomer(@RequestBody Customer customer){
        customerService.update(customer);
    }
    /*@PutMapping("/{id}")  //?  ToDo
    public void updateCustomer(@RequestBody Customer customer, @PathVariable Integer id){
        customerService.update(customer);
    }
*/
    //Elimina
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Integer id){
        customerService.deleteById(id);
    }

    //ToDo ? Discernetra le due getMapping aggiungendo all'endpoint la coppia chiave-valore GET /customers?byFirstNameOppByLastName=lastName
    //Ricerca filtrata e paginata
    @GetMapping
    public List<Customer> getPaginatedCustomersFirstNameOppByName(
            @RequestParam @Size(min = 2, message = "Inserire almeno 2 caratteri") String firstName,
            @RequestParam @Size(min = 2, message = "Inserire almeno 2 caratteri") String lastName,
            @RequestParam(defaultValue="0") int page,
            @RequestParam(defaultValue="10") int size) {
        return customerService.getPaginatedByFirstNameOppByLastNameCustomers(firstName, lastName, page, size);
    }
   /* @GetMapping
    public Page<Customer> getPaginatedCustomers(
            @RequestParam(defaultValue="0") int page,
            @RequestParam(defaultValue="10") int size) {
        return customerService.getPaginatedCustomers(page, size);
    }
    */
}