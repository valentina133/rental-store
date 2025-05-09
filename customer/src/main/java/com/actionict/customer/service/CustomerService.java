package com.actionict.customer.service;

import com.actionict.customer.model.Customer;
import com.actionict.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    //Trova Uno
    public Customer findById(Integer id) {

        return customerRepository.findById(id);
    }

    //Inserisci
    public void inserisci(Integer id, String firstName, String lastName, String email, Boolean active, LocalDateTime createData) {
        Customer customer=new Customer (id, firstName, lastName, email, active, createData);
        customerRepository.save(customer);
    }

    //Aggiorna
    public void update(Integer id, String newFirstName, String newLastName, String newEmail, Boolean newActive, LocalDateTime newCreateData) {
        Customer customer=customerRepository.findById(id);
        customer.setFirstName(newFirstName);
        customer.setLastName(newLastName);
        customer.setEmail(newEmail);
        customer.setActive(newActive);
        customer.setCreateData(newName);
        customerRepository.save(newCreateData);
    }

    //Elimina
    public void deleteById(Integer id) { customerRepository.deleteById(id); }

    //ToDo
    //Ricerca filtrata e paginata
    public Page<Customer> getPaginatedByFirstNameOppByLastNameCustomers (String byFirstNameOppByLastName, int page, int size) {
        Pageable pageable=PageRequest.of(page, size);
        if (byFirstNameOppByLastName=="firstName") return customerRepository.findByFirstName(firstName, pageable);
        if (byFirstNameOppByLastName=="lastName") return customerRepository.findByLastName(lastName, pageable);
    }
    /*public Page<Customer> getPaginatedCustomers (int page, int size) {
        Pageable pageable=PageRequest.of(page, size);
        return customerRepository.findAll(pageable);
    }
     */
}