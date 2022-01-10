package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Student;
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
	
	@GetMapping
	public ResponseEntity<List<StudentDTO>> getStudents(){

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
	
	@PostMapping
//	@PreAuthorize("hasAnyRole('ROLE_ADMINISTRATOR')")
	public ResponseEntity<StudentDTO> saveStudent(@RequestBody StudentDTO studentDTO){
		User user = userServiceInterface.findOne(studentDTO.getUserDTO().getIdUser());
		Student student = new Student();
		student.setCardNumber(studentDTO.getCardNumber());
		student.setUser(user);
		student = studentServiceInterface.save(student);
		
		return new ResponseEntity<StudentDTO>(new StudentDTO(student), HttpStatus.CREATED);
	}

	@PutMapping()
	@PreAuthorize("hasAnyRole('ROLE_STUDENT', 'ROLE_ADMINISTRATOR')")
	public ResponseEntity<StudentDTO> updateStudent(@RequestBody StudentDTO studentDTO){
		User user = userServiceInterface.findOne(studentDTO.getUserDTO().getIdUser());
		Student student = studentServiceInterface.findById(studentDTO.getId());
		if(student == null) {
			return new ResponseEntity<StudentDTO>(HttpStatus.NOT_FOUND);
		}
		student.setCardNumber(studentDTO.getCardNumber());
		student.setUser(user);
		studentServiceInterface.save(student);
		return new ResponseEntity<StudentDTO>(new StudentDTO(student), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	@PreAuthorize("hasAnyRole('ROLE_ADMINISTRATOR')")
	public ResponseEntity<Void> deleteStudent(@PathVariable("id") Long id){
		Student student = studentServiceInterface.findOne(id);
		if(student != null) {
			studentServiceInterface.remove(id);
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
}
