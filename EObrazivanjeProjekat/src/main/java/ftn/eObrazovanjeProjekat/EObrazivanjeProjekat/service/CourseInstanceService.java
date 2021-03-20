package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.CourseInstance;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository.CourseInstanceRepository;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.CourseInstanceServiceInterface;

@Service
public class CourseInstanceService implements CourseInstanceServiceInterface{
	
	@Autowired 
	CourseInstanceRepository courseInstanceRepository;

	@Override
	public List<CourseInstance> findAll() {
		return courseInstanceRepository.findAll();
	}

	@Override
	public CourseInstance findOne(Long id) {
		return courseInstanceRepository.getOne(id);
	}

	@Override
	public CourseInstance findById(Long courseInstanceId) {
		return courseInstanceRepository.findByIdCourseInstance(courseInstanceId);
	}

	@Override
	public CourseInstance save(CourseInstance courseInstance) {
		return courseInstanceRepository.save(courseInstance);
	}

	@Override
	public void remove(Long id) {
		courseInstanceRepository.deleteById(id);
		
	}

}
