package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface;

import java.util.List;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.CourseSpecification;

public interface CourseSpecificationServiceInterface {
	
	public List<CourseSpecification> findAll();
	public CourseSpecification findOne(Long id);
	public CourseSpecification findById(Long id);
	public CourseSpecification save(CourseSpecification courseSpecification);
	public void remove(Long id);

}
