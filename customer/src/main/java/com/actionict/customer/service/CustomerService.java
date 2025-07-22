package com.actionict.customer.service;

import com.actionict.customer.model.Address;
import com.actionict.customer.model.Customer;
import com.actionict.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    //Trova Uno
    public Customer findById(Integer id) {
        return customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente non trovato:"+id));
    }

    //Inserisci
    public void inserisci(Customer customer) {
        customerRepository.save(customer);
    }

    //Aggiorna
    public void update(Integer id, Customer customer) {
        Customer customerByDB = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente non trovato:"+id));;
        String newFirstName=customer.getFirstName();
        String newLastName=customer.getLastName();
        String newEmail=customer.getEmail();
        Boolean newActive=customer.getActive();
        LocalDateTime newCreateDate=customer.getCreateDate();
        Address address=customer.getAddress();   //chiave esterna
        Integer newAddressId=address.getId();    //chiave esterna

        customerByDB.setFirstName(newFirstName);
        customerByDB.setLastName(newLastName);
        customerByDB.setEmail(newEmail);
        customerByDB.setActive(newActive);
        customerByDB.setCreateDate(newCreateDate);
        Address addressByDB=customerByDB.getAddress();   //chiave esterna
        addressByDB.setId(newAddressId);       //chiave esterna
        customerByDB.setAddress(addressByDB);      //chiave esterna

        customerRepository.save(customerByDB);
    }

    //Elimina
    public void deleteById(Integer id) {
        customerRepository.deleteById(id);
    }

    //Ricerca filtrata e paginata
    public Page<Customer> searchFilterPaginatedCustomers(String firstName, String lastName, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return customerRepository.findByLastNameOrFirstNameNative(firstName, lastName, pageable);
    }
}