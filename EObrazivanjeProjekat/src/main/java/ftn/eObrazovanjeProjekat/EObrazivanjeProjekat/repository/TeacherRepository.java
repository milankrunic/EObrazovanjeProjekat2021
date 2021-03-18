package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{

	Teacher findByIdTeacher(Long id);
	
}
