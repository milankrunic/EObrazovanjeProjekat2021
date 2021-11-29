package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Exam;


public interface ExamRepository extends JpaRepository<Exam, Long>{
	
//	List<Exam> findAllExam(Long idExam);
	Exam findByIdExam(Long idExam);
//	Exam saveExam(Exam exam);
//	Exam addById(Long idExam);
//	Exam updateById(Long idExam);
//	Exam removeById(Long idExam);

	List<Exam> findByEnrollment(Long id);

	List<Exam> findByEnrollment_student_cardNumber(String cardNum);
	
	
}
