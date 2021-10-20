package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto.EnrollmentDTO;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto.StudentDTO;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.CourseInstance;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Enrollment;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Student;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.CourseInstanceServiceInterface;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.EnrollmentServiceInterface;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.StudentServiceInterface;

@RestController
@RequestMapping(value = "api/enrollment")
public class EnrollmentController {
	
	@Autowired
	EnrollmentServiceInterface enrollmentServiceInterface;
	
	@Autowired
	StudentServiceInterface studentServiceInterface;
	
	@Autowired
	CourseInstanceServiceInterface courseInstanceServiceInterface;
	
	@GetMapping
	public ResponseEntity<List<EnrollmentDTO>> getAll(){
		List<Enrollment> enrollments = enrollmentServiceInterface.findAll();
		
		List<EnrollmentDTO> endto = new ArrayList<EnrollmentDTO>();
		
		for(Enrollment e: enrollments) {
			endto.add(new EnrollmentDTO(e));
		}
		return new ResponseEntity<List<EnrollmentDTO>>(endto, HttpStatus.OK);
	}

	
	@GetMapping(value = "/{id}")
	public ResponseEntity<EnrollmentDTO> getOne(@PathVariable("id") Long id){
		Enrollment enrollment = enrollmentServiceInterface.findOne(id);
		if(enrollment == null) {
			return new ResponseEntity<EnrollmentDTO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<EnrollmentDTO>(new EnrollmentDTO(enrollment), HttpStatus.OK);
	}
	
	@PutMapping()
	@PreAuthorize("hasAnyRole('ROLE_TEACHER', 'ROLE_ADMINISTRATOR')")
	public ResponseEntity<EnrollmentDTO> update(@RequestBody EnrollmentDTO enrollmentDTO){
		Student student = studentServiceInterface.findById(enrollmentDTO.getStudentDTO().getId());
		CourseInstance courseInstance = courseInstanceServiceInterface.findById(enrollmentDTO.getCourseInstanceDTO().getIdCourseInstance());
		
		Enrollment enrollment = enrollmentServiceInterface.findOne(enrollmentDTO.getIdEnrollment());
		if(enrollment == null) {
			return new ResponseEntity<EnrollmentDTO>(HttpStatus.NOT_FOUND);
		}
		enrollment.setStudent(student);
		enrollment.setCourseInstance(courseInstance);
		enrollment = enrollmentServiceInterface.save(enrollment);
		return new ResponseEntity<EnrollmentDTO>(new EnrollmentDTO(enrollment), HttpStatus.OK);
	}
	
	@GetMapping(value = "/my-enrollments")
	public ResponseEntity<List<EnrollmentDTO>> getMyEnrollments(ModelMap model, Principal principal){
		String username = principal.getName();
		Student student = studentServiceInterface.findByUser(username);
		
		
		List<Enrollment> enrollments =  student.getEnrollments();
		
		List<EnrollmentDTO> endto = new ArrayList<EnrollmentDTO>();
		
		for(Enrollment e: enrollments) {
			endto.add(new EnrollmentDTO(e));
		}
		return new ResponseEntity<List<EnrollmentDTO>>(endto, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{idCourseInstance}/{cardNumber}")
	public ResponseEntity<Void> deleteEnrollment(@PathVariable("idCourseInstance") Long idCourseInstance,@PathVariable("cardNumber") String cardNumber){
		Enrollment enrollment = enrollmentServiceInterface.findByCourseInstanceAndStudent(idCourseInstance, cardNumber);
		if(enrollment != null) {
			enrollmentServiceInterface.delete(enrollment.getIdEnrollment());
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	
}
