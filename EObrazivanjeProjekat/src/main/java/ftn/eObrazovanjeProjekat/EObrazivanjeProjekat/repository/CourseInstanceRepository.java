package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.CourseInstance;

public interface CourseInstanceRepository extends JpaRepository<CourseInstance, Long>{
	
	CourseInstance findByIdCourseInstance(Long id);
	
//	@Query(value = "SELECT * FROM studentskasluzba.course_instance\r\n" + 
//			"	where id_course_instance in (SELECT id_course_instance FROM studentskasluzba.enrollment\r\n" + 
//			"					where student in (SELECT id FROM studentskasluzba.student\r\n" + 
//			"											where id_user in (SELECT id_user FROM studentskasluzba.user\r\n" + 
//			"												where username LIKE :userName)))", nativeQuery = true)
//	Page<CourseInstance> findByStudent(@Param("userName") String username,Pageable page);
	//greska za ovaj query?
	
	//java.sql.SQLSyntaxErrorException: Unknown column 'id' in 'field list'

}
