package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.CourseSpecification;

public interface CourseSpecificationRepository extends JpaRepository<CourseSpecification, Long>{

	CourseSpecification findByIdCourseSpecification(Long id);
	
}
