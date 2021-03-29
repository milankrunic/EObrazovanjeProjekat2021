package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface;

import java.util.List;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.StudentPayments;

public interface StudentPaymentsServiceInterface {
	

	public StudentPayments findOne(Long id);
	public StudentPayments save(StudentPayments studentPayments);
//	List<StudentPayments> findByStudentId(Long id);
	void remove(StudentPayments studentPayments);
	List<StudentPayments> findByAccountId(Long id);

}
