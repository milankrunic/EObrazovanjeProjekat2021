package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto.ExamDTO;import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Enrollment;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Exam;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Student;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.EnrollmentServiceInterface;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.ExamServiceInterface;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.StudentServiceInterface;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.UserServiceInterface;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "api/exam")
public class ExamController {

	@Autowired
	ExamServiceInterface examServiceInterface;
	
	@Autowired
	UserServiceInterface userServiceInterface;
	
	@Autowired
	StudentServiceInterface studentServiceInterface;
	
	@Autowired 
	EnrollmentServiceInterface ennrolmentServiceInterface;
	

	@GetMapping()
	@PreAuthorize("hasAnyRole('ROLE_STUDENT')")
	public ResponseEntity<List<ExamDTO>> getAll(Principal principal){
		String name = principal.getName();
		System.out.println(name);
		Student s = studentServiceInterface.findByUser(name);
		
		System.out.println("card number is - " + s.getCardNumber());
		
		List<Exam> exams = examServiceInterface.examForStudent(s.getCardNumber());
		System.out.println(exams);
		List<ExamDTO> dtos = new ArrayList<>();
		
		for (Exam exam : exams) {
			dtos.add(new ExamDTO(exam));
		}
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
//	@GetMapping(value = "/all-exams")
//	@PreAuthorize("hasAnyRole('ROLE_ADMINISTRATOR')")
//	public ResponseEntity<List<ExamDTO>> getAll(){
//		
//		List<Exam> exams = examServiceInterface.findAll();
//		
//		List<ExamDTO> dtos = new ArrayList<ExamDTO>();
//		
//		for (Exam exam : exams) {
//			dtos.add(new ExamDTO(exam));
//		}
//		return new ResponseEntity<List<ExamDTO>>(dtos, HttpStatus.OK);
//	}
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ExamDTO> getOneExam(@PathVariable("id") Long id){
		System.out.println("uslooo!!");
		
		Exam exam = examServiceInterface.findOne(id);
		if(exam == null) {
			return new ResponseEntity<ExamDTO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ExamDTO>(new ExamDTO(exam), HttpStatus.OK);
	}
	
	@PutMapping()
	@PreAuthorize("hasAnyRole('ROLE_TEACHER', 'ROLE_ADMINISTRATOR')")
	public ResponseEntity<ExamDTO> updateExam(@RequestBody ExamDTO dto){
		System.out.println("\nAzuriram exam\n");
		Exam exam = examServiceInterface.findOne(dto.getId());
		if(exam == null) {
			return ResponseEntity.notFound().build();
		}
		exam.setPoints(dto.getPoints());
		exam.setGrade(dto.getGrade());
		
		exam = examServiceInterface.save(exam);
		
		return new ResponseEntity<ExamDTO>(new ExamDTO(exam), HttpStatus.OK);
	}
	
	@PostMapping
	@PreAuthorize("hasAnyRole('ROLE_TEACHER', 'ROLE_ADMINISTRATOR')")
	public ResponseEntity<ExamDTO> saveExam(@RequestBody ExamDTO dto){
		Exam exam = new Exam();   
		Enrollment enrollment = ennrolmentServiceInterface.findOne(dto.getEnrollmentDTO().getIdEnrollment());
		exam.setPoints(null);
		exam.setGrade(dto.getGrade());
		exam.setEnrollment(enrollment);
		
		exam = examServiceInterface.save(exam);
		
		return new ResponseEntity<ExamDTO>(new ExamDTO(exam), HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = "/{id}")
	@PreAuthorize("hasAnyRole('ROLE_ADMINISTRATOR')")
	public ResponseEntity<Void> deleteExam(@PathVariable("id") Long id){
		Exam exam = examServiceInterface.findOne(id);
		if(exam != null) {
			examServiceInterface.remove(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(value = "/my-passed-exams/{code}")
	@PreAuthorize("hasAnyRole('ROLE_STUDENT')")
	public ResponseEntity<List<ExamDTO>> passedExams(Principal principal,@PathVariable("code") String code) {
		String name = principal.getName(); //get logged in username
		Student st = studentServiceInterface.findByUser(name);
		List<ExamDTO> passed = new ArrayList<ExamDTO>();
		List<ExamDTO> failed = new ArrayList<ExamDTO>();
		List<Exam> exams = examServiceInterface.examPassedForStudent(st.getCardNumber());
//		List<ExamDTO> dtos = new ArrayList<ExamDTO>();
		for (Exam exam : exams) {
			if(6 <= exam.getGrade()) {
				passed.add(new ExamDTO(exam));
			}
			else
				failed.add(new ExamDTO(exam));
		}
		if(code.equals("pa")) {
			return new ResponseEntity<List<ExamDTO>>(passed, HttpStatus.OK);
		}
		return new ResponseEntity<List<ExamDTO>>(failed, HttpStatus.OK);
	}
	
//	@GetMapping(value = "/student/{cardNumber}")
//	@PreAuthorize("hasAnyRole('ROLE_TEACHER', 'ROLE_ADMINISTRATOR')")
//	public ResponseEntity<List<ExamDTO>> getAllExamsByStudent(@PathVariable("cardNumber") String cardNumber){
//		List<Exam> exams = examS.examPassedForStudent(cardNumber);
//		
//		List<ExamDTO> dtos = new ArrayList<ExamDTO>();
//		
//		for (Exam exam : exams) {
//			dtos.add(new ExamDTO(exam));
//		}
//		return new ResponseEntity<List<ExamDTO>>(dtos, HttpStatus.OK);
//	}
//	
//	@PostMapping(value = "/register-exam")
//	@PreAuthorize("hasAnyRole('ROLE_TEACHER', 'ROLE_ADMINISTRATOR')")
//	public ResponseEntity<ExamDTO> registerExam(@RequestBody ExamDTO dto, Principal principal){
//		Exam exam = new Exam();
//		String username = principal.getName(); 
//		Enrollment enrollment = enrollmentS.findById(dto.getEnrollmentDTO().getId());
//		enrollment.setStudent(studServ.findByUser(username));
//		enrollment = enrollmentS.save(enrollment);
//		exam.setPoints();
//		exam.setGradle(dto.getGradle());
//		exam.setEnrollment(enrollment);
//		
//		exam = examS.save(exam);
//		
//		return new ResponseEntity<ExamDTO>(new ExamDTO(exam), HttpStatus.CREATED);
//	}
	
	

	
}
