package com.actionict.customer.repository;

import com.actionict.customer.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value="SELECT * FROM CUSTOMER WHERE first_name like %?1% OR last_name like %?2%", nativeQuery = true)
    Page<Customer> findByLastNameOrFirstNameNative(String firstName, String lastName, Pageable pageable);
}