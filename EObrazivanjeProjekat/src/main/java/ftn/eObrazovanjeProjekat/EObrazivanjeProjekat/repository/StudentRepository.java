package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Student;


public interface StudentRepository extends JpaRepository<Student, Long>{
	List<Student> findAllByLastName(String lastName);

}
