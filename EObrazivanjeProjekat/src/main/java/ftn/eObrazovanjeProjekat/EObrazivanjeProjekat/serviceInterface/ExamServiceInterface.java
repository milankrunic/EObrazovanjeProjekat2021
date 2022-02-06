package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Enrollment;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Exam;

public interface ExamServiceInterface {

	Exam save(Exam exam);

	void remove(Exam exam);

	Exam findOne(Long id);

	List<Exam> getAllExamsByEnrollments(Long id);

	List<Exam> findAll();

	List<Exam> examForStudent(String cardNum);

	List<Exam> findByCourseInstance(Long idCourseInstance);

	void remove(Long id);

	List<Exam> examPassedForStudent(String cardNumber);


}
