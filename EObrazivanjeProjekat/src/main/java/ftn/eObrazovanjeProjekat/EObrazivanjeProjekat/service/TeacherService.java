package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Teacher;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository.TeacherRepository;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.TeacherServiceInterface;

@Service
public class TeacherService implements TeacherServiceInterface{

//	As a Teacher, I want to see list of my teaching, so that I know what I teach.
//	As a Teacher, I want to see list of my courses instance, so that I know when I teach.
//	As a Teacher, I want to see list of exams, so that I know when I have.
	
	@Autowired
	TeacherRepository teacherRepository;

	@Override
	public List<Teacher> findAll() {
		return teacherRepository.findAll();
	}

	@Override
	public Teacher findOne(Long id) {
		return teacherRepository.getOne(id);
	}

	@Override
	public Teacher findById(Long teacherId) {
		return teacherRepository.findByIdTeacher(teacherId);
	}

	@Override
	public Teacher save(Teacher teacher) {
		return teacherRepository.save(teacher);
	}

	@Override
	public void remove(Long id) {
		teacherRepository.deleteById(id);
		
	}
	
	@Override
	public Teacher findByUsername(String username) {
		return teacherRepository.findOneByUser_username(username);
	}

	@Override
	public Long count() {
		return teacherRepository.count();
	}
	
}
