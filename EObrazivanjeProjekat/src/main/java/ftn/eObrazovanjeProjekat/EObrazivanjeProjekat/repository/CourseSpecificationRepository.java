package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.CourseSpecification;

public interface CourseSpecificationRepository extends JpaRepository<CourseSpecification, Long>{

	CourseSpecification findByIdCourseSpecification(Long id);
//	@Query(value = "SELECT * FROM studentskasluzba.course_specification\r\n" + 
//			"where code LIKE concat('%',:searchString,'%') or title LIKE concat('%',:searchString,'%')", nativeQuery = true)
//Page<CourseSpecification> findAll(@Param("searchString") String searchString, Pageable page);

	
}
