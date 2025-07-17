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
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    //Trova Uno
    public Customer findById(Integer id) {
        Optional<Customer> byId = customerRepository.findById(id);
        Customer customer = byId.get();
        return customer;
    }

    //Inserisci
    public void inserisci(Customer customer) {
        customerRepository.save(customer);
    }

    //Aggiorna
    public void update(Integer id, Customer customer) {
        Optional<Customer> customerOpt = customerRepository.findById(id);
        String newFirstName=customer.getFirstName();
        String newLastName=customer.getLastName();
        String newEmail=customer.getEmail();
        Boolean newActive=customer.getActive();
        LocalDateTime newCreateDate=customer.getCreateDate();
        //Address address=customer.getAddress();
        //Integer newAddressId=address.getId();
        customerOpt.get().setFirstName(newFirstName);
        customerOpt.get().setLastName(newLastName);
        customerOpt.get().setEmail(newEmail);
        customerOpt.get().setActive(newActive);
        customerOpt.get().setCreateDate(newCreateDate);
        //Address addressByOpt=customerOpt.get().getAddress();
        //addressByOpt.setId(newAddressId);
        //customerOpt.get().setAddress(addressByOpt);
        customerRepository.save(customerOpt.get());
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