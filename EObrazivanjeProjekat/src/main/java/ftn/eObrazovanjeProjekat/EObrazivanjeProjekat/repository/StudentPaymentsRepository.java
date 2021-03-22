package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.StudentPayments;

public interface StudentPaymentsRepository extends JpaRepository<StudentPayments, Long> {
<<<<<<< HEAD
	
	StudentPayments findByPaymentId(Long id);
	StudentPayments  removeById(Long id);
	StudentPayments savePayment(StudentPayments studentPayments);
=======

	
>>>>>>> branch 'master' of https://github.com/milankrunic/EObrazovanjeProjekat2021.git
}
