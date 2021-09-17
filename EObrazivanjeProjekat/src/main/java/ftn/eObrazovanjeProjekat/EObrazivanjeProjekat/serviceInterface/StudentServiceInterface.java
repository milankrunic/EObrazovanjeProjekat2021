package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface;

import java.util.List;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.ExamPart;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Student;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Teacher;

public interface StudentServiceInterface {
	
	Student save(Student account);
	
	void remove(Long id);

//	List<Student> findAllByUser(Long id);

	Student findOne(Long id);
	
	public Student findById(Long studentId);

//	Student updateStudent(Student student);

	Student findByCard(String cardNumber);

	List<ExamPart> findAllExamParts(Student student);

	List<Student> findAllByUser(Long id);

	List<Student> findAll();

}
