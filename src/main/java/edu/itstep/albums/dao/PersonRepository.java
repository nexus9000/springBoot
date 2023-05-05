package edu.itstep.albums.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
	List<Person> findByName(String name);

	List<Person> findByAge(int age);

	Optional<Person> findById(int id);

}
