package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Teaching;

public interface TeachingRepository extends JpaRepository<Teaching, Long>{
	
	Teaching findByIdTeaching(Long id);
	Teaching findOneTeachingByTeacher_idTeacher(Long teacherId);
	List<Teaching> findAllTeachingByTeacher_idTeacher(Long teacherId);
	
}
