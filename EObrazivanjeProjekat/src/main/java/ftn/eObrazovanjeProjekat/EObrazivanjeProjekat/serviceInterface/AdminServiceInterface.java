package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface;

import java.util.List;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Teacher;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Admin;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Exam;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Student;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.StudentPayments;

public interface AdminServiceInterface {
	
	public List<Teacher> findAllTeacher(Long idTeacher);
	public Teacher findOneTeacher(Long idTeacher);
	public Teacher findByIdTeacher(Long idTeacher);
	public Teacher saveTeacher(Teacher teacher);
	public void addTeacher(Long idTeacher);
	public void updateTeacher(Long idTeacher);
	public void removeTeacher(Long idTeacher);
	
	public Admin findByUser(String username);
	
	public List<Student> findAllStudent(Long idStudent);
	public Student findOneStudent(Long idStudent);
	public Student findByIdStudent(Long idStudent);
	public Student saveStudent(Student student);
	public void addStudent(Long idStudent);
	public void updateStudent(Long idStudent);
	public void removeStudent(Long idStudent);
	
	public StudentPayments findStudentPaymentByStudent(Long idStudent);
	
	public List<Exam> findAllExam(Long idExam);
	public Exam findOneExam(Long idExam);
	public Exam findByIdExam(Long idExam);
	public Exam saveExam(Exam exam);
	public void addExam(Long idExam);
	public void updateExam(Long idExam);
	public void removeExam(Long idExam);
	
	
	public List<Admin> findAllAdmin();
	public Admin findOneAdmin(Long idAdmin);
	public Admin findById(Long idAdmin);
	public Admin saveAdmin(Admin admin);
	public void addAdmin(Long idAdmin);
	public void updateAdmin(Long idAdmin);
	public void remove(Long idAdmin);
//	public Admin findByUser(String username);
}
