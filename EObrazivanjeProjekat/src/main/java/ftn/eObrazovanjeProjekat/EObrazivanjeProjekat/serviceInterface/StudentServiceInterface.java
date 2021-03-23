package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface;

import java.util.List;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Student;

public interface StudentServiceInterface {
	
	Student save(Student account);
	
	void remove(Student account);

	List<Student> findAllByUser(Long id);

	Student findOne(Long id);

	Student updateStudent(Student student);

}
