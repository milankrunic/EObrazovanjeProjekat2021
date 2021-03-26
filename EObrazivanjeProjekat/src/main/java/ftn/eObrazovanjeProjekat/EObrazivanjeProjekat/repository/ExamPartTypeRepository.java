package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.ExamPartType;

public interface ExamPartTypeRepository extends JpaRepository<ExamPartType, Long>{

	List<ExamPartType> findByIdExamPartType(Long id);
	
	
}
