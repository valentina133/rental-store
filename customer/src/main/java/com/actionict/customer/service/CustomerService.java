package com.actionict.customer.service;

import com.actionict.customer.model.Address;
import com.actionict.customer.model.Country;
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
    public void inserisci(String firstName, String lastName, String email, Boolean active, LocalDateTime createData, Integer id) {
        Customer customer = new Customer();
        //customer.setId(id);
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setEmail(email);
        customer.setActive(active);
        customer.setCreateDate(createData);
        Address address = new Address();
        address.setId(id);
        customer.setAddress(address);
        customerRepository.save(customer);
    }

    //Aggiorna
    public void update(Integer id, String newFirstName, String newLastName, String newEmail, Boolean newActive, LocalDateTime newCreateDate) {
        Optional<Customer> customer = customerRepository.findById(id);
        //Customer customer = (Customer) customerObject;
        //customer.setId(id);
        customer.get().setFirstName(newFirstName);
        customer.get().setLastName(newLastName);
        customer.get().setEmail(newEmail);
        customer.get().setActive(newActive);
        customer.get().setCreateDate(newCreateDate);
        customerRepository.save(customer.get());
    }

    //Elimina
    public void deleteById(Integer id) {
        customerRepository.deleteById(id);
    }

    //ToDo
    //Ricerca filtrata e paginata
    public Page<Customer> searchFilterPaginatedCustomers(String firstName, String lastName, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

                //return customerRepository.findByLastnameOrFirstname(firstName, lastName, pageable);  //da errore
                //return customerRepository.findByLastNameOrFirstName(firstName, lastName, pageable);

                return customerRepository.findByLastNameOrFirstNameNative(firstName, lastName, pageable);
    }
}