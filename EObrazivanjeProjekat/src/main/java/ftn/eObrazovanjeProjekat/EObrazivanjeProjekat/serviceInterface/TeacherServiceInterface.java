package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface;

import java.util.List;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Teacher;

public interface TeacherServiceInterface {
	
	public List<Teacher> findAll();
	public Teacher findOne(Long id);
	public Teacher findById(Long teacherId);
	public Teacher save(Teacher teacher);
	public void remove(Long id);
	public Teacher findByUsername(String username);

}
