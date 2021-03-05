package com.uniovi.repositories;

import com.uniovi.entities.*;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<User, Long> {

	User findByDni(String dni);
	
	
	@Query("SELECT r FROM User r WHERE r.name =?1")
	List<User> searchByName( String searchText);
	
	@Query("SELECT r FROM User r WHERE r.lastName =?1")
	List<User> searchByLastName(String searchText);
	
	@Query("SELECT r FROM User r WHERE (LOWER (r.name) LIKE LOWER (?1) OR LOWER (r.lastName) LIKE LOWER (?1))")
	List<User> searchByNameAndLastName(String searchText);
	
}

