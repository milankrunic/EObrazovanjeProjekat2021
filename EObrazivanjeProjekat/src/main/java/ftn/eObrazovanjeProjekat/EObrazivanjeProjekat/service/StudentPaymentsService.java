package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.StudentPayments;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository.StudentPaymentsRepository;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.StudentPaymentsServiceInterface;

@Service
public class StudentPaymentsService implements StudentPaymentsServiceInterface {

	@Autowired
	StudentPaymentsRepository studentPaymentsRepository;
	@Override
	public StudentPayments findByStudentId(Long id) {
		return null;
	}

	@Override
	public StudentPayments findOne(Long id) {
		return studentPaymentsRepository.findByPaymentId(id);
	}

	@Override
	public StudentPayments save(StudentPayments studentPayments) {
		 return studentPaymentsRepository.savePayment(studentPayments);
	}

	@Override
	public void remove(Long id) {
		studentPaymentsRepository.removeById(id);
		
	}

}
