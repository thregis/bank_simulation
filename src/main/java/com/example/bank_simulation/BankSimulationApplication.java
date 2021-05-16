package com.example.bank_simulation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackages = { "com.example.bank_simulation.model" })
public class BankSimulationApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankSimulationApplication.class, args);
	}

}
