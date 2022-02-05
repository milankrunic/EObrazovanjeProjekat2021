package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.CourseInstance;

public interface CourseInstanceRepository extends JpaRepository<CourseInstance, Long>{
	
	CourseInstance findByIdCourseInstance(Long id);
	
	@Query(value = "SELECT * FROM studentskasluzba.course_instance\r\n" + 
			"	where id in (SELECT id_course_instance FROM studentskasluzba.teaching\r\n" + 
			"					where id_teacher in (SELECT id FROM studentskasluzba.teacher\r\n" + 
			"											where user_id in (SELECT id FROM studentskasluzba.user\r\n" + 
			"												where username LIKE :userName)))", nativeQuery = true)
	Page<CourseInstance> findByTeacher(@Param("userName") String username,Pageable page);
	
	@Query(value = "SELECT count(*) FROM studentskasluzba.course_instance\r\n" + 
			"				where id in (SELECT id_course_instance FROM studentskasluzba.teaching\r\n" + 
			"								where id_teacher in (SELECT id FROM studentskasluzba.teacher\r\n" + 
			"														where user_id in (SELECT id FROM studentskasluzba.user\r\n" + 
			"															where username LIKE :userName)))", nativeQuery = true)
	Long countForTeacher(@Param("userName") String username);
	
	@Query(value = "SELECT * FROM studentskasluzba.course_instance\r\n" + 
			"	where id in (SELECT id_course_instance FROM studentskasluzba.enrollment\r\n" + 
			"					where id_student in (SELECT id FROM studentskasluzba.student\r\n" + 
			"											where user_id in (SELECT id FROM studentskasluzba.user\r\n" + 
			"												where username LIKE :userName)))", nativeQuery = true)
	Page<CourseInstance> findByStudent(@Param("userName") String username,Pageable page);

	@Query(value = "SELECT count(*) FROM studentskasluzba.course_instance\r\n" + 
			"				where id in (SELECT course_instance_id FROM studentskasluzba.enrollment\r\n" + 
			"								where id_student in (SELECT id FROM studentskasluzba.student\r\n" + 
			"														where user_id in (SELECT id FROM studentskasluzba.user\r\n" + 
			"															where username LIKE :userName)))", nativeQuery = true)
	Long countForStudent(@Param("userName") String username);

}
