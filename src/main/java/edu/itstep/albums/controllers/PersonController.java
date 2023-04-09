package edu.itstep.albums.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.itstep.albums.dao.PersonRepository;
import edu.itstep.albums.exceptions.PersonNotFoundException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import edu.itstep.albums.dao.Person;

@RestController
@RequestMapping("/api/v1")
public class PersonController {

	@Autowired
	private PersonRepository personRepository;
      
	@GetMapping("/test")
	String testMessage() {
		return "test Message";
	}

	@GetMapping("/persons")
	List<Person> all() {
		return (List<Person>) personRepository.findAll();
	}

	
	@GetMapping("/persons/id/{id}")
	Optional<Person> getById(@NotNull @PathVariable long id) {
		return Optional.ofNullable(personRepository.findById(id).orElseThrow(()->new PersonNotFoundException(id))) ;
	}
	
	@PostMapping("/person")
	Person addPerson(@Valid @RequestBody Person newPerson) {
		 return personRepository.save(newPerson);
	 }
	 @DeleteMapping("/person/delete/id/{id}")
	  void deletePerson(@NotNull @PathVariable long id) {
		  personRepository.deleteById(id);
	  }
}
