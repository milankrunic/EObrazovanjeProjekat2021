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

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto.ExamDTO;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto.StudentDTO;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Exam;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Student;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.User;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.ExamServiceInterface;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.StudentServiceInterface;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.UserServiceInterface;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "api/enrollments/{idEnrollment}/exams")
public class ExamController {

	@Autowired
	ExamServiceInterface examServiceInterface;
	
	@Autowired
	UserServiceInterface userServiceInterface;
	
	@GetMapping
	public ResponseEntity<List<ExamDTO>> getExamsByEnrollments(@PathVariable("idEnrollment") Long id){
		
		List<Exam> exams = examServiceInterface.getAllExamsByEnrollments(id);
		
		List<ExamDTO> examDTO = new ArrayList<ExamDTO>();
		for(Exam exam: exams) {
			examDTO.add(new ExamDTO(exam));
		}
		return new ResponseEntity<List<ExamDTO>>(examDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ExamDTO> getExam(@PathVariable("id") Long id){
		Exam exam = examServiceInterface.findOne(id);
		
		if(exam == null) {
			return new ResponseEntity<ExamDTO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ExamDTO>(new ExamDTO(exam), HttpStatus.OK);
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<ExamDTO> addExam(@RequestBody ExamDTO examDTO){

		
		Exam e = new Exam();
		e.setPoints(examDTO.getPoints());	
		e.setGrade(examDTO.getGrade());
//		e.setExamPart(examDTO.getExamParts());
		
		
		
		e = examServiceInterface.save(e);
		return new ResponseEntity<ExamDTO>(new ExamDTO(e), HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}", consumes = "application/json")
	public ResponseEntity<ExamDTO> updateExam(@RequestBody ExamDTO examDTO, @PathVariable("id") Long id){

		Exam exam = examServiceInterface.findOne(id);
		
		
		if(exam == null) {
			return new ResponseEntity<ExamDTO>(HttpStatus.BAD_REQUEST);
		}
		exam.setPoints(examDTO.getPoints());
		exam.setGrade(examDTO.getGrade());
//		exam.setExamParts(examDTO.getExamParts());
		
		exam = examServiceInterface.save(exam);
		return new ResponseEntity<ExamDTO>(new ExamDTO(exam), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteExam(@PathVariable("id") Long id){
		Exam exam = examServiceInterface.findOne(id);
		if(exam != null) {
			examServiceInterface.remove(exam);
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
}
