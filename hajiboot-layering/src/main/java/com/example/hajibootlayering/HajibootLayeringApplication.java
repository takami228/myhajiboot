package com.example.hajibootlayering;

import com.example.hajibootlayering.domain.Customer;
import com.example.hajibootlayering.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HajibootLayeringApplication implements CommandLineRunner {
	@Autowired
	CustomerService customerService;


	public static void main(String[] args) {
		SpringApplication.run(HajibootLayeringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		customerService.save(new Customer(1, "Nobita", "Nobi"));
		customerService.save(new Customer(2, "Takeshi", "Goda"));
		customerService.save(new Customer(3, "Suneo", "Honekawa"));
		customerService.findAll().forEach(System.out::println);
	}
}
