package edu.itstep.albums.dao;




import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends CrudRepository<User,Long>{
	
}
