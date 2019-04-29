package com.example.hajibootdi;

import com.example.hajibootdi.app.Argument;
import com.example.hajibootdi.app.ArgumentResolver;
import com.example.hajibootdi.app.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class HajibootDiApplication implements CommandLineRunner {
	@Autowired
	ArgumentResolver argumentResolver;
	@Autowired
	Calculator calculator;

	@Override
	public void run(String... strings) throws Exception {
		System.out.println("Enter 2 number linke 'a b' : ");
		Argument argument = argumentResolver.resolve(System.in);
		int result = calculator.calc(argument.getA(), argument.getB());
		System.out.println("result = " + result);
	}

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(HajibootDiApplication.class, args);
	}

}
