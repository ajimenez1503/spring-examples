package com.example.accessingdatarest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
@RestController
public class AccessingdatarestApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccessingdatarestApplication.class, args);
	}

	@Autowired
	private PersonRepository repository;

	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!\n";
	}

	@GetMapping("/person")
	public Person findPerson() {
		return repository.findByFirstName("Frodo");
	}

	@PostMapping("/addperson")
	public Person addPerson(@RequestBody Person newPerson) {
		return repository.save(newPerson);
	}

}
