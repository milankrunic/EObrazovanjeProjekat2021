package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.StudentPayments;

public interface StudentPaymentsServiceInterface {
	
	public StudentPayments findByStudentId(Long id);
	public StudentPayments findOne(Long id);
	public StudentPayments save(StudentPayments studentPayments);
	public void remove(Long id);

}
