package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Student;


public interface StudentRepository extends JpaRepository<Student, Long>{
	
//	List<Student> findByUser_id(Long id);
	
//	List<Student> findAllStudent(Long idStudent);
	Student findByIdStudent(Long idStudent);
//	Student saveStudent(Student student);
//	Student addById(Long idStudent);
//	Student updateById(Long idStudent);
//	Student removeById(Long idStudent);

	List<Student> findByUser_id(Long id);

	Student findOneByCardNumber(String cardNumber);
	
	Student findOneByUser_username(String username);

	@Query("SELECT max(id) FROM Student")
	Long maxID();

}
