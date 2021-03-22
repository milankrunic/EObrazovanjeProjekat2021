package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long>{

	List<Enrollment> findByStudent_id(Long id);

}
