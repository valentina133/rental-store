package com.actionict.customer.repository;

import com.actionict.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findByFirstName(String firstName);
    List<Customer> findByLastName(String lastName);
}