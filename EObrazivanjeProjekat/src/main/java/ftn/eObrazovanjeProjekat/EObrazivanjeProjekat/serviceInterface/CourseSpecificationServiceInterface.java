package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.CourseSpecification;

public interface CourseSpecificationServiceInterface {
	
//	public Page<CourseSpecification> findAll(Pageable page);
//	
//	public Page<CourseSpecification> findAll(String searchString,Pageable page);
	public List<CourseSpecification> findAll();
	public CourseSpecification findOne(Long id);
	public CourseSpecification findById(Long id);
	public CourseSpecification save(CourseSpecification courseSpecification);
	public void remove(Long id);
	
}
