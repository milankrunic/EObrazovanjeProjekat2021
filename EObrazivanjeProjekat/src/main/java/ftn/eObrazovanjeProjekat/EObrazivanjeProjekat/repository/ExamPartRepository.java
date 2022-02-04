package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.ExamPart;

public interface ExamPartRepository extends JpaRepository<ExamPart, Long>{
	
	List<ExamPart> findByIdExamPart(Long id);

	List<ExamPart> findByExam(Long id);

	List<ExamPart> findByExamPartStatus_codeAndExam_enrollment_student_cardNumber(String code, String cardNum);

//	List<ExamPart> idCourseInstance(Long idCourseInstance);
	
	@Query(value="SELECT * " + 
			"FROM studentskasluzba.exam_part " + 
			"WHERE exam in (SELECT id_exam FROM studentskasluzba.exam " + 
			"WHERE enrollment in (SELECT id_enrollment FROM studentskasluzba.enrollment " + 
			"WHERE course_instance in (SELECT course_instance FROM studentskasluzba.teaching " + 
			"WHERE teacher in (SELECT id_teacher  FROM studentskasluzba.teacher " + 
			"WHERE id_user = (SELECT id FROM studentskasluzba.user " + 
			"WHERE username LIKE :username ))))) ",nativeQuery = true)
	List<ExamPart>  findByTeacher(@Param("username") String username);


}
