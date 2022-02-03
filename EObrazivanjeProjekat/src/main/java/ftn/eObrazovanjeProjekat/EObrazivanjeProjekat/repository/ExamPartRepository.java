package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Exam;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.ExamPart;

public interface ExamPartRepository extends JpaRepository<ExamPart, Long>{

	List<ExamPart> findByIdExamPart(Long id);

	List<ExamPart> findByExam(Long id);

	List<ExamPart> findByExamPartStatus_codeAndExam_enrollment_student_cardNumber(String code, String cardNum);

//	List<ExamPart> idCourseInstance(Long idCourseInstance);
	
//	List<ExamPart>  findByTeacher(@Param("username") String username);
//	
//	@Query(value="SELECT *\r\n" + 
//			"FROM studentskasluzba.exam_part\r\n" + 
//			"WHERE exam in (SELECT id_exam FROM studentskasluzba.exam\r\n" + 
//			"WHERE enrollment in (SELECT id_enrollment FROM studentskasluzba.enrollment\r\n" + 
//			"WHERE course_instance in (SELECT course_instance FROM studentskasluzba.teaching\r\n" + 
//			"WHERE teacher in (SELECT id_teacher  FROM studentskasluzba.teacher \r\n" + 
//			"WHERE id_user = (SELECT id FROM studentskasluzba.user\r\n" + 
//			"WHERE username LIKE :username)))))",nativeQuery = true)
//	Long countByTeacher(@Param("username") String username);

}
