package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.StudentPayments;

public interface StudentPaymentsRepository extends JpaRepository<StudentPayments, Long> {
	
	StudentPayments findByPaymentId(Long id);
	StudentPayments  removeById(Long id);
	StudentPayments savePayment(StudentPayments studentPayments);
}
