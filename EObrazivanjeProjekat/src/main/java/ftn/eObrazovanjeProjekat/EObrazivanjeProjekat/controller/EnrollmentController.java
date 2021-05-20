package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto.EnrollmentDTO;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto.StudentDTO;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Enrollment;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Student;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.EnrollmentServiceInterface;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.StudentServiceInterface;

@RestController
@RequestMapping(value = "api/students/{idStudent}/enrollments")
public class EnrollmentController {
	
	@Autowired
	EnrollmentServiceInterface enrollmentServiceInterface;
	
	@GetMapping
	public ResponseEntity<List<EnrollmentDTO>> getEnrollmentByStudent(@PathVariable("idStudent") Long idStudent){

		List<Enrollment> enrollments = enrollmentServiceInterface.findAllByStudent(idStudent);
		
		List<EnrollmentDTO> enrollmentDTO = new ArrayList<>();
		for(Enrollment enrollment: enrollments) {
			enrollmentDTO.add(new EnrollmentDTO(enrollment));
		}	
		return new ResponseEntity<List<EnrollmentDTO>>(enrollmentDTO, HttpStatus.OK);
	}
	

	
	@GetMapping(value = "/{id}")
	public ResponseEntity<EnrollmentDTO> getEnrollment(@PathVariable("id") Long id){
		Enrollment enrollment = enrollmentServiceInterface.findOne(id);
		
		if(enrollment == null) {
			return new ResponseEntity<EnrollmentDTO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<EnrollmentDTO>(new EnrollmentDTO(enrollment), HttpStatus.OK);
	}
	
	
	
	
}
