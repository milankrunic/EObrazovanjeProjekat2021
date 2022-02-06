package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.CourseSpecification;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository.CourseSpecificationRepository;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.CourseSpecificationServiceInterface;

@Service
public class CourseSpecificationService implements CourseSpecificationServiceInterface{
	
	@Autowired
	CourseSpecificationRepository courseSpecificationRepository;

	@Override
	public List<CourseSpecification> findAll() {
		return courseSpecificationRepository.findAll();
	}


	@Override
	public CourseSpecification findOne(Long id) {
		return courseSpecificationRepository.getOne(id);
	}

	@Override
	public CourseSpecification findById(Long courseSpecificationid) {
		return courseSpecificationRepository.findByIdCourseSpecification(courseSpecificationid);
	}

	@Override
	public CourseSpecification save(CourseSpecification courseSpecification) {
		return courseSpecificationRepository.save(courseSpecification);
	}

	@Override
	public void remove(Long id) {
		courseSpecificationRepository.deleteById(id);
		
	}
	
//	@Override
//	public Page<CourseSpecification> findAll(String searchString, Pageable page) {
//		return courseSpecificationRepository.findAll(searchString, page);
//	}

}
