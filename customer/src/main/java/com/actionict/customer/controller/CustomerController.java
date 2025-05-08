package com.actionict.customer.controller;

import com.actionict.customer.model.Customer;
import com.actionict.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Customer> getCustomers(@PathVariable Integer id){
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

    //ToDo ? da risolvere come fa a discernere tra le due getMapping
    //Ricerca filtrata e paginata
    @GetMapping
    public Page<Customer> getPaginatedCustomers(
            @RequestParam(defaultValue="0") int page,
            @RequestParam(defaultValue="10") int size) {
        return customerService.getPaginatedCustomers(page, size);
    }
}