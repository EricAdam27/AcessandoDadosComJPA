package com.example.accessingdatajpa;

import com.example.accessingdatajpa.model.CustomerModel;
import com.example.accessingdatajpa.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataJpaApplication {

	private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AccessingDataJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			// save a few customers
			repository.save(new CustomerModel("Jack", "Bauer"));
			repository.save(new CustomerModel("Chloe", "O'Brian"));
			repository.save(new CustomerModel("Kim", "Bauer"));
			repository.save(new CustomerModel("David", "Palmer"));
			repository.save(new CustomerModel("Michelle", "Dessler"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (CustomerModel customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			CustomerModel customer = repository.findById(1L);
			log.info("Customers found with findById(1L):");
			log.info("----------------------------------");
			log.info(customer.toString());
			log.info("");

			// fetch customer by last name
			log.info("Customers found with findByLastName('Bauer'):");
			log.info("---------------------------------------------");
			repository.findByLastName("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});
			// for (CustomerModel bauer : repository.findByLastName("Bauer")) {
			//     log.info(bauer.toString());
			// }
			log.info("");
		};
	}
}
