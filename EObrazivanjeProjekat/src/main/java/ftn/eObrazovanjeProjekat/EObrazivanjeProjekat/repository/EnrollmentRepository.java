package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.CourseInstance;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Enrollment;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Exam;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long>{

	List<Enrollment> findByIdEnrollment(Long id);

	List<Enrollment> findAllByStudent(Long id);

	List<Enrollment> findAllByCourseInstance(CourseInstance courseInstance);

	List<Enrollment> findByStudent(Long id);
	
	



}
