package com.example.Onetoone;

import com.example.Onetoone.Model.Address;
import com.example.Onetoone.Model.Person;
import com.example.Onetoone.Repo.AddressRepository;
import com.example.Onetoone.Repo.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnetooneApplication implements CommandLineRunner {

	@Autowired
	PersonRepository personRepo;
	@Autowired
	AddressRepository addressRepo;

	public static void main(String[] args) {
		SpringApplication.run(OnetooneApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Address address = Address.builder().city("Hanoi").province("Bac Tu Liem").build();
		addressRepo.save(address);

		Person person = Person.builder().name("Thinh").address(address).build();
		personRepo.save(person);

	}

}
