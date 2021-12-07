package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.ExamPart;

public interface ExamPartRepository extends JpaRepository<ExamPart, Long>{

	List<ExamPart> findByIdExamPart(Long id);

	List<ExamPart> findByExam(Long id);

	List<ExamPart> findByExamPartStatus_codeAndExam_enrollment_student_cardNumber(String code, String cardNum);

//	List<ExamPart> idCourseInstance(Long idCourseInstance);
	
//	Page<ExamPart> findByCourseInstance(Long cousrseId, Pageable page);

}
