package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.CourseInstance;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Enrollment;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository.EnrollmentRepository;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.EnrollmentServiceInterface;

@Service
public class EnrollmentService implements EnrollmentServiceInterface {
	
	@Autowired
	EnrollmentRepository enrollmentRepository;
	

	@Override
	public Enrollment findOne(Long id) {
		return enrollmentRepository.getOne(id);
	}

	@Override
	public Enrollment save(Enrollment enrollment) {
		return enrollmentRepository.save(enrollment);
	}

	@Override
	@Transactional
	public void remove(Enrollment enrollment) {
		
		enrollmentRepository.delete(enrollment);
	}
//	ennrollments by course
	@Override
	public List<Enrollment> getAllEnrollmentsByCourse(CourseInstance courseInstance) {
		List<Enrollment> enrollments = enrollmentRepository.findAllByCourseInstance(courseInstance);
		return enrollments;
	}

//	enrollments by student
//	@Override
//	public List<Enrollment> findAllByStudent(Long id) {
//		return enrollmentRepository.findAllByStudent(id);
//	}
	
	@Override
	public List<Enrollment> findAllByStudent(Long id) {
		return enrollmentRepository.findByStudent(id);
	}
	
//	add enrolment
//	ovo jos videti ako budemo brisali metodu COurseInstance pa dodavati startDate i endDate u enrollments
	@Override
	public Enrollment add(Enrollment newEnrollment) {
		Enrollment enrollment = new Enrollment();
		enrollment.setExam(newEnrollment.getExam());
		
		enrollment = this.enrollmentRepository.save(enrollment);
		return enrollment;
	}

	@Override
	public List<Enrollment> findAll() {
		return enrollmentRepository.findAll();
	}
	
	@Override
	public Enrollment findByCourseInstanceAndStudent(Long idCourseInstance, String cardNumber) {
		return enrollmentRepository.findByCourseInstance_idAndStudent_cardNumber(idCourseInstance, cardNumber);
	}

	@Override
	public void delete(Long id) {
		 enrollmentRepository.deleteById(id);
		
	}
	
}