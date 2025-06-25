package com.actionict.customer.repository;

import com.actionict.customer.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Page<Customer> findByFirstName(String firstName, Pageable pageable);
    Page<Customer> findByLastName(String lastName, Pageable pageable);
    //Page<Customer> findByFirstNameAndLastName(String firstName, String lastName, Pageable pageable);
    //Page<Customer> findByLastnameOrFirstname(String firstName, String lastName, Pageable pageable);

    //Page<Customer> findByLastNameOrFirstName(String firstName, String lastName, Pageable pageable);

    @Query(value="SELECT * FROM CUSTOMER WHERE first_name like %?1% OR last_name like %?2%", nativeQuery = true)
    Page<Customer> findByLastNameOrFirstNameNative(String firstName, String lastName, Pageable pageable);
    //List<Customer> findByLastNameOrFirstNameNative(String firstName, String lastName);

    //Query query=select * from customer where first_name like '%str%' or last_name like '%str%'
}