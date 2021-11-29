package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Admin;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Exam;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Student;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.StudentPayments;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Teacher;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository.AdminRepository;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository.ExamRepository;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository.StudentRepository;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository.TeacherRepository;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.AdminServiceInterface;

@Service
public class AdminService implements AdminServiceInterface{

//	As a Admin, I want to put money into the student account, so that they can pay for the exam.
//	As an Admin, I want to see my profile, so that I can create and update my profile.
//	As a Admin, I want create update delete student, so that I work on them.
//	As a Admin, I want create update delete teacher, so that I work on them.
//	As a Admin, I want create update delete exam, so that I work on them.
	
	//TEACHER
	@Autowired
	TeacherRepository teacherRepository;

	public List<Teacher> findAllTeacher() {
		return teacherRepository.findAll();
	}

	public Teacher findOneTeacher(Long idTeacher) {
		return teacherRepository.getOne(idTeacher);
	}

	public Teacher findByIdTeacher(Long idTeacher) {
		return teacherRepository.findByIdTeacher(idTeacher);
	}

	@Override
	public Teacher saveTeacher(Teacher teacher) {
		return teacherRepository.save(teacher);
	}

//	public void addTeacher(Long idTeacher) {
//		teacherRepository.addById(idTeacher);
//	}
	
//	public void updateTeacher(Long idTeacher) {
//		teacherRepository.updateById(idTeacher);
//	}
//	
//	public void removeTeacher(Long idTeacher) {
//		teacherRepository.removeById(idTeacher);
//	}
	
	
	
	
	//STUDENT
	@Autowired
	StudentRepository studentRepository;

	public List<Student> findAllStudent() {
		return studentRepository.findAll();
	}

	public Student findOneStudent(Long idStudent) {
		return studentRepository.getOne(idStudent);
	}

	public Student findByIdStudent(Long idStudent) {
		return studentRepository.findByIdStudent(idStudent);
	}

	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

//	public void addStudent(Long idStudent) {
//		studentRepository.addById(idStudent);
//	}
//	
//	public void updateStudent(Long idStudent) {
//		studentRepository.updateById(idStudent);
//	}
//	
//	public void removeStudent(Long idStudent) {
//		studentRepository.removeById(idStudent);
//	}
	
	
	
	
	//EXAM
	@Autowired
	ExamRepository examRepository;

	public List<Exam> findAllExam() {
		return examRepository.findAll();
	}

	public Exam findOneExam(Long idExam) {
		return examRepository.getOne(idExam);
	}

	public Exam findByIdExam(Long idExam) {
		return examRepository.findByIdExam(idExam);
	}

	public Exam saveExam(Exam exam) {
		return examRepository.save(exam);
	}

//	public void addExam(Long idExam) {
//		examRepository.addById(idExam);
//	}
//	
//	public void updateExam(Long idExam) {
//		examRepository.updateById(idExam);
//	}
//	
//	public void removeExam(Long idExam) {
//		examRepository.removeById(idExam);
//	}
	
	
	
	
	
	//ADMIN
	@Autowired
	AdminRepository adminRepository;

	public List<Admin> findAllAdmin() {
		return adminRepository.findAll();
	}

	public Admin findOneAdmin(Long idAdmin) {
		return adminRepository.getOne(idAdmin);
	}

	public Admin findByIdAdmin(Long idAdmin) {
		return adminRepository.findByIdAdmin(idAdmin);
	}

	public Admin saveAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

	@Override
	public List<Teacher> findAllTeacher(Long idTeacher) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addTeacher(Long idTeacher) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTeacher(Long idTeacher) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTeacher(Long idTeacher) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Student> findAllStudent(Long idStudent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addStudent(Long idStudent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateStudent(Long idStudent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeStudent(Long idStudent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public StudentPayments findStudentPaymentByStudent(Long idStudent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Exam> findAllExam(Long idExam) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addExam(Long idExam) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateExam(Long idExam) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeExam(Long idExam) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addAdmin(Long idAdmin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAdmin(Long idAdmin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Long idAdmin) {
		adminRepository.deleteById(idAdmin);
		
	}

	@Override
	public Admin findById(Long idAdmin) {
		return adminRepository.findByIdAdmin(idAdmin);
	}

//	@Override
//	public Admin findByUser(String username) {
//		return adminRepository.findOneByUser_username(username);
//	}

}
