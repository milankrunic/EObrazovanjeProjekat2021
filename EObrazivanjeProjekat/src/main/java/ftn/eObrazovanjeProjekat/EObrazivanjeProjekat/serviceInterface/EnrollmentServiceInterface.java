package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface;

import java.util.List;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.CourseInstance;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Enrollment;

public interface EnrollmentServiceInterface {

	List<Enrollment> findAllByStudent(Long id);

	Enrollment findOne(Long id);

	Enrollment save(Enrollment enrollment);

	void remove(Enrollment enrollment);

	Enrollment add(Enrollment newEnrollment);

	List<Enrollment> getAllEnrollmentsByCourse(CourseInstance courseInstance);

}
