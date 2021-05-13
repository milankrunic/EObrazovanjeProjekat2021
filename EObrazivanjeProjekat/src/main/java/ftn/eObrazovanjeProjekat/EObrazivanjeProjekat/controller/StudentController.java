package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto.StudentDTO;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto.TeacherDTO;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Student;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Teacher;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.User;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.StudentServiceInterface;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.UserServiceInterface;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "api/students")
public class StudentController {

	@Autowired
	StudentServiceInterface studentServiceInterface;
	
	@Autowired
	UserServiceInterface userServiceInterface;
	
//	@GetMapping
//	public ResponseEntity<List<StudentDTO>> getStudentsByUser(@PathVariable("idUser") Long id){
//
//		List<Student> students = studentServiceInterface.findAllByUser(id);
//		
//		List<StudentDTO> studentDTO = new ArrayList<StudentDTO>();
//		for(Student student: students) {
//			studentDTO.add(new StudentDTO(student));
//		}
//		return new ResponseEntity<List<StudentDTO>>(studentDTO, HttpStatus.OK);
//	}
	
	
	@GetMapping
	public ResponseEntity<List<StudentDTO>> getStudentsByUser(){

		List<Student> students = studentServiceInterface.findAll();
		
		List<StudentDTO> studentDTO = new ArrayList<StudentDTO>();
		for(Student student: students) {
			studentDTO.add(new StudentDTO(student));
		}
		return new ResponseEntity<List<StudentDTO>>(studentDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<StudentDTO> getStudent(@PathVariable("id") Long id){
		Student student = studentServiceInterface.findOne(id);
		
		if(student == null) {
			return new ResponseEntity<StudentDTO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<StudentDTO>(new StudentDTO(student), HttpStatus.OK);
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<StudentDTO> addStudent(@RequestBody StudentDTO studentDTO){

		User u = userServiceInterface.findById(studentDTO.getUserId());
		Student s = new Student();
		s.setFirstName(studentDTO.getFirstName());	
		s.setLastName(studentDTO.getLastName());
		s.setEmail(studentDTO.getEmail());
		s.setCardNumber(studentDTO.getCardNumber());

		s.setUser(u);
		
		s = studentServiceInterface.save(s);
		return new ResponseEntity<StudentDTO>(new StudentDTO(s), HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}", consumes = "application/json")
	public ResponseEntity<StudentDTO> updateStudent(@RequestBody StudentDTO studentDTO, @PathVariable("id") Long studentId){

		Student student = studentServiceInterface.findById(studentId);
		User user = userServiceInterface.findById(studentDTO.getUserId());
		
		if(student == null) {
			return new ResponseEntity<StudentDTO>(HttpStatus.BAD_REQUEST);
		}
		student.setFirstName(studentDTO.getFirstName());
		student.setLastName(studentDTO.getLastName());
		student.setEmail(studentDTO.getEmail());
		student.setCardNumber(studentDTO.getCardNumber());
		
		student.setUser(user);

		return new ResponseEntity<StudentDTO>(new StudentDTO(student), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable("id") Long id){
		Student student = studentServiceInterface.findOne(id);
		if(student != null) {
			studentServiceInterface.remove(id);
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
}
