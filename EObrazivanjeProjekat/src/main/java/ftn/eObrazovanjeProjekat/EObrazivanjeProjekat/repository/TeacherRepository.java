package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{

//	List<Teacher> findAllTeacher(Long idTeacher);
	Teacher findByIdTeacher(Long idTeacher);
//	Teacher saveTeacher(Teacher teacher);
//	Teacher addById(Long idTeacher);
//	Teacher updateById(Long idTeacher);
//	Teacher removeById(Long idTeacher);

	Teacher findOneByUser_username(String username);

//	void addById(Long idTeacher);
	
}
