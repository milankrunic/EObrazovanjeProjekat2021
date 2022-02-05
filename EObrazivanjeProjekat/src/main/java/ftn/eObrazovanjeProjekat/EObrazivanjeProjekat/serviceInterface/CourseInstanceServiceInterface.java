package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.CourseInstance;

public interface CourseInstanceServiceInterface {

	public Page<CourseInstance> getAll(Pageable page);
	
	public CourseInstance findById(Long id);
	
	public CourseInstance save(CourseInstance ci);
	
	public void delete(Long id);
	
	public Page<CourseInstance> findByTeacher(String username,Pageable page);
	
	public Page<CourseInstance> findByStudent(String username,Pageable page);
	
	public Long countAll();
	
	public Long countForTeacher(String username);
	
	public Long countForStudent(String username);
	
}
