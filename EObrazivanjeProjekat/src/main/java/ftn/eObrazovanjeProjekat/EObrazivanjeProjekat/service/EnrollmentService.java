package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Enrollment;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository.EnrollmentRepository;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.EnrollmentServiceInterface;

public class EnrollmentService implements EnrollmentServiceInterface {
	
	@Autowired
	EnrollmentRepository enrollmentRepository;
	
	@Override
	public List<Enrollment> findAllByStudent(Long id) {
		return enrollmentRepository.findByStudent_id(id);
	}

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

}
