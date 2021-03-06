package com.example.hajibootjdbc.repository;

import com.example.hajibootjdbc.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class CustomerRepository {
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    private static final RowMapper<Customer> customerRowMapper = (rs, i) -> {
        Integer id = rs.getInt("id");
        String first_name = rs.getString("first_name");
        String last_name = rs.getString("last_name");
        return new Customer(id, first_name, last_name);
    };

    public List<Customer> findAll(){
        List<Customer> customers = jdbcTemplate.query(
                "SELECT id, first_name, last_name FROM customers ORDER BY id", customerRowMapper
        );
        return customers;
    }

    public Customer findOne(Integer customerId){
        SqlParameterSource param = new MapSqlParameterSource().addValue("id", customerId);
        return jdbcTemplate.queryForObject(
                "SELECT id, first_name, last_name FROM customers WHERE id = :id",
                param,
                customerRowMapper
        );
    }

    public Customer save(Customer customer){
        SqlParameterSource param = new BeanPropertySqlParameterSource(customer);
        if(customer.getId() == null){
            jdbcTemplate.update("INSERT INTO customers(first_name, last_name) values(:firstName, :lastName)", param);
        } else {
            jdbcTemplate.update("UPDATE customers SET first_name=:firstName, last_name=:lastName WHERE id = :id", param);
        }
        return customer;
    }

    public void delete(Integer customerId){
        SqlParameterSource param = new MapSqlParameterSource().addValue("id", customerId);
        jdbcTemplate.update("DELETE FROM customers WHERE id = :id", param);
    }
}
