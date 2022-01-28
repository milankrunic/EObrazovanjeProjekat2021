package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.CourseInstance;

public interface CourseInstanceServiceInterface {

	public List<CourseInstance> findAll();
	public CourseInstance findOne(Long id);
	public CourseInstance findById(Long courseInstanceId);
	public CourseInstance save(CourseInstance courseInstance);
	public void remove(Long id);
//	public List<CourseInstance> findByStudent(String username);
	public Long countAll();
	
	public Long countForTeacher(String username);
	
	public Long countForStudent(String username);
	
}
