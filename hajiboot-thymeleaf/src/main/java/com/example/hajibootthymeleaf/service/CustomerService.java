package com.example.hajibootthymeleaf.service;

import com.example.hajibootthymeleaf.domain.Customer;
import com.example.hajibootthymeleaf.domain.User;
import com.example.hajibootthymeleaf.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;


    public List<Customer> findAll(){
        return customerRepository.findAll();
    }

    public Page<Customer> findAll(Pageable pageable){
        return customerRepository.findAllOrderByName(pageable);
    }

    public Optional<Customer> findOne(Integer id){
        return customerRepository.findById(id);
    }

    public Customer create(Customer customer, User user){
        customer.setUser(user);
        return customerRepository.save(customer);
    }

    public Customer update(Customer customer, User user){
        customer.setUser(user);
        return customerRepository.save(customer);
    }

    public void delete(Integer id){
        customerRepository.deleteById(id);
    }
}
