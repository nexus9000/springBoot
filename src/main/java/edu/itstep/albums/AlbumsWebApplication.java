package edu.itstep.albums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import edu.itstep.albums.dao.Person;
import edu.itstep.albums.dao.PersonRepository;

@SpringBootApplication
public class AlbumsWebApplication {
   Logger logger = LoggerFactory.getLogger(AlbumsWebApplication.class);
	public static void main(String[] args) {
		 
		SpringApplication.run(AlbumsWebApplication.class, args);
	}
	@Bean
	public CommandLineRunner run(PersonRepository personRepo) {
		return(String[] arg)->{
			Person person1 = new Person("John Smith", 23);
			logger.trace(person1 + " was added");
			Person person2 = new Person("Jane Dow", 10);
			logger.trace(person2 + " was added");
			//personRepo.save(person1);
			//personRepo.save(person2);
			
		};
	}
}
