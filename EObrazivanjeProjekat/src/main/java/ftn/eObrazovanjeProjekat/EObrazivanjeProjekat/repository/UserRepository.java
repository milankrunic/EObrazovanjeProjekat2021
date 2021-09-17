package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.User ;


public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findById(Long id);

	User findByUsername(String username);
	
}
