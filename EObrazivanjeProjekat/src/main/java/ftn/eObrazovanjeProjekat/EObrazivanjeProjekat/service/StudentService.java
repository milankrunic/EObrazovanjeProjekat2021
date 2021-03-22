package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Student;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository.StudentRepository;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.StudentServiceInterface;


@Service
public class StudentService implements StudentServiceInterface {
	
	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public List<Student> findAllByUser(Integer id) {
		return studentRepository.findByUser_id(id);
	}

	@Override
	public Student findOne(Integer id) {
//		ovde treba dodati funkciju kad se obrisu iz studentRepositoryja nepotrebne
		return null;
	}

	@Override
	public Student save(Student student) {
		return studentRepository.save(student);
	}

	@Override
	@Transactional
	public void remove(Student student) {
		
		studentRepository.delete(student);
	}


	

}