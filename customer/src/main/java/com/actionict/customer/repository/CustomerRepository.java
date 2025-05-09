package com.actionict.customer.repository;

import com.actionict.customer.model.Customer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findByFirstName(String firstName, Pageable pageable);
    List<Customer> findByLastName(String lastName, Pageable pageable);
}