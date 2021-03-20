package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface;

import java.util.List;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.CourseInstance;

public interface CourseInstanceServiceInterface {

	public List<CourseInstance> findAll();
	public CourseInstance findOne(Long id);
	public CourseInstance findById(Long courseInstanceId);
	public CourseInstance save(CourseInstance courseInstance);
	public void remove(Long id);
	
}
