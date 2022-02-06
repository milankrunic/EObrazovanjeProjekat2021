package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.StudentPayments;

public interface StudentPaymentsRepository extends JpaRepository<StudentPayments, Long> {

	List<StudentPayments> findByIdStudentPayments(Long id);

	List<StudentPayments> findAllByAccount(Long id);

	Page<StudentPayments> findByAccount_student_user_username(String username, Pageable page);
}
