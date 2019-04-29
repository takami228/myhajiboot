package com.example.hajibootjdbc;

import com.example.hajibootjdbc.domain.Customer;
import com.example.hajibootjdbc.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;

@SpringBootApplication
public class HajibootJdbcApplication implements CommandLineRunner {
	@Autowired
	CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(HajibootJdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Customer created = customerRepository.save(new Customer(null, "Hidetoshi", "Dekisugi"));
		System.out.println(created + " is created!");
		customerRepository.findAll().forEach(System.out::println);
	}
}
