package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.StudentPayments;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository.StudentPaymentsRepository;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.StudentPaymentsServiceInterface;

@Service
public class StudentPaymentsService implements StudentPaymentsServiceInterface {

	@Autowired
	StudentPaymentsRepository studentPaymentsRepository;
	
	
	@Override
	public List<StudentPayments> findByAccountId(Long id) {
		return studentPaymentsRepository.findAllByAccount(id);
	}

	@Override
	public StudentPayments findOne(Long id) {
		return studentPaymentsRepository.getOne(id);
	}

	@Override
	public StudentPayments save(StudentPayments studentPayments) {
		 return studentPaymentsRepository.save(studentPayments);
	}

	@Override
	@Transactional
	public void remove(StudentPayments studentPayments) {
		studentPaymentsRepository.delete(studentPayments);
		
	}

	@Override
	public void remove(Long id) {
		studentPaymentsRepository.deleteById(id);
		
	}
	
	@Override
	public Page<StudentPayments> findByUsername(String username,Pageable page) {
		// TODO Auto-generated method stub
		return studentPaymentsRepository.findByAccount_student_user_username(username,page);
	}



}
