package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Enrollment;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Exam;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Student;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository.EnrollmentRepository;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository.ExamRepository;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.ExamServiceInterface;

@Service
public class ExamService implements ExamServiceInterface {
	
	@Autowired
	ExamRepository examRepository;
	
	@Autowired
	EnrollmentRepository enrollmentRepository;
	
	
	public List<Exam> getAllExamsByEnrollments(Long id) {
		return examRepository.findByEnrollment(id);
	}
	
	public List<Exam> findAll() {
		return examRepository.findAll();
	}
	
	
	@Override
	public Exam findOne(Long id) {
		return examRepository.getOne(id);
	}

	@Override
	public Exam save(Exam exam) {
		return examRepository.save(exam);
	}
	
	

	@Override
	@Transactional
	public void remove(Exam exam) {
		
		examRepository.delete(exam);
	}
	
	@Override
	public List<Exam> examForStudent(String cardNum) {
		return examRepository.findByEnrollment_student_cardNumber(cardNum);
	}

	

//	@Override
//	public List<Exam> findByCourseInstance(Long idCourseInstance) {
//		return examRepository.findByEnrollment_courseInstance_id(courseId);
//	}

	@Override
	public void remove(Long id) {
		examRepository.deleteById(id);
		
	}

	@Override
	public List<Exam> findByCourseInstance(Long idCourseInstance) {
		// TODO Auto-generated method stub
		return null;
	}

}
