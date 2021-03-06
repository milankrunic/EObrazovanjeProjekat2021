package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.ExamPart;

public interface ExamPartRepository extends JpaRepository<ExamPart, Long>{

	List<ExamPart> findByIdExamPart(Long id);

	List<ExamPart> findByExam(Long id);

}
