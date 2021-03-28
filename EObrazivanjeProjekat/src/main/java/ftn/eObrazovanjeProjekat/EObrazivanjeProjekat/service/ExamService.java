package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Enrollment;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Exam;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Enrollment;
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

}
