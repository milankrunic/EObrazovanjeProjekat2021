package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.ExamPart;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Student;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository.ExamPartRepository;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository.ExamRepository;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository.StudentRepository;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.StudentServiceInterface;


@Service
public class StudentService implements StudentServiceInterface {
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	ExamPartRepository examPartRepository;
	
//	@Override
//	public List<Student> findAllByUser(Long id) {
//		return studentRepository.findByUser_id(id);
//	}

	@Override
	public Student findOne(Long id) {
		return studentRepository.findById(id).get();
	}

	@Override
	public Student save(Student student) {
		return studentRepository.save(student);
	}
	
	@Override
	public Student updateStudent(Student student) {
		Student studentUpdate = studentRepository.findById(student.getIdStudent()).get();
		studentUpdate.setFirstName(student.getFirstName());
		studentUpdate.setLastName(student.getLastName());
		
		return studentUpdate;
		
	}

	@Override
	@Transactional
	public void remove(Student student) {
		
		studentRepository.delete(student);
	}

//	@Override
//	public void save(Object obj) {
//		this.studentRepository.save((Student)obj);
//		
//	}

//	get exams of student
	public List<ExamPart> findAllExamParts(Student student) {
		return examPartRepository.findAll();
	}
	
//	students amount of money
	
//	exam information - preko enrollmenta
	
//	remaining exams for student - preko enrollmenta
	
	

	

}