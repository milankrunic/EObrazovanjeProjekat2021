package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface;

import java.util.List;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository.StudentRepository;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Student;

public interface StudentServiceInterface {
	
	List<Student> findAllByUser(Integer id);
	
	Student findOne(Integer id);
	
	Student save(Student account);
	
	void remove(Student account);

}
