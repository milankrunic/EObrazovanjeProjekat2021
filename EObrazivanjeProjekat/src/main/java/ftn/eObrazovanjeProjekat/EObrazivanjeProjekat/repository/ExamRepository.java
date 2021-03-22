package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Exam;


public interface ExamRepository extends JpaRepository<Exam, Long>{
	
	List<Exam> findByStudent_id(Long id);
	
	List<Exam> findAllExam(Long idExam);
	Exam findByIdExam(Long idExam);
	Exam saveExam(Exam exam);
	Exam addById(Long idExam);
	Exam updateById(Long idExam);
	Exam removeById(Long idExam);

	
}
