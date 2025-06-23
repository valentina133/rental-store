package com.actionict.customer.repository;

import com.actionict.customer.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Page<Customer> findByFirstName(String firstName, Pageable pageable);
    Page<Customer> findByLastName(String lastName, Pageable pageable);
    Page<Customer> findByFirstNameAndLastName(String firstName, String lastName, Pageable pageable);
}