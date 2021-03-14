package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.User ;


public interface UserRepository extends JpaRepository<User, Long>{

}
