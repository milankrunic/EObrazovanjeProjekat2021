package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Teacher;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository.TeacherRepository;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.TeacherServiceInterface;

@Service
public class TeacherService implements TeacherServiceInterface{

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
	
}
