package com.example.hajibootjpa.repository;

import com.example.hajibootjpa.domain.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query("SELECT X FROM Customer X ORDER BY X.firstName, X.lastName")
    Page<Customer> findAllOrderByName(Pageable pageable);
}
