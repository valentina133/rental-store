package com.actionict.customer.service;

import com.actionict.customer.model.Customer;
import com.actionict.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    //Trova Uno
    public Object findById(Integer id) {

        return customerRepository.findById(id);
    }

    //Inserisci
    public void inserisci(Integer id, String firstName, String lastName, String email, Boolean active, LocalDateTime createData) {
        Customer customer=new Customer (id, firstName, lastName, email, active, createData);
        customerRepository.save(customer);
    }

    //Aggiorna
    public void update(Integer id, String newFirstName, String newLastName, String newEmail, Boolean newActive, LocalDateTime newCreateDate) {
        Optional<Customer> customer=customerRepository.findById(id);
        customer.setFirstName(newFirstName);
        customer.setLastName(newLastName);
        customer.setEmail(newEmail);
        customer.setActive(newActive);
        customer.setCreateDate(newCreateDate);
        customerRepository.save(customer);
    }

    //Elimina
    public void deleteById(Integer id) { customerRepository.deleteById(id); }

    //ToDo
    //Ricerca filtrata e paginata
    public List<Customer> getPaginatedByFirstNameOppByLastNameCustomers (String firstName, String lastName, int page, int size) {
        Pageable pageable= PageRequest.of(page, size);

        if (firstName!=null && lastName==null) return customerRepository.findByFirstName(firstName, pageable);
        else return customerRepository.findByLastName(lastName, pageable);
        //if (firstName!=null && lastName==null) return customerRepository.findByFirstName(firstName, pageable);
        // else if (lastName!=null && firstName==null) return customerRepository.findByLastName(lastName, pageable);
    }
    /*public Page<Customer> getPaginatedCustomers (int page, int size) {
        Pageable pageable=PageRequest.of(page, size);
        return customerRepository.findAll(pageable);
    }
     */
}