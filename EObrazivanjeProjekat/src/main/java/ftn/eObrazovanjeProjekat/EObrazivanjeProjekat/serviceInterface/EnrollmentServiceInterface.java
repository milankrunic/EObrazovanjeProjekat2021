package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface;

import java.util.List;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.CourseInstance;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Enrollment;

public interface EnrollmentServiceInterface {
	
	public List<Enrollment> findAll();
	
	List<Enrollment> findAllByStudent(Long id);

	Enrollment findOne(Long id);

	Enrollment save(Enrollment enrollment);

	void remove(Enrollment enrollment);
	
	public void delete(Long id);

	Enrollment add(Enrollment newEnrollment);

	List<Enrollment> getAllEnrollmentsByCourse(CourseInstance courseInstance);
	
	public Enrollment findByCourseInstanceAndStudent(Long idCourseInstance,String cardNumber);
	

}
