package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto.ExamPartDTO;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.ExamPart;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.ExamPartServiceInterface;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.UserServiceInterface;

public class ExamPartController {
	
	@Autowired
	ExamPartServiceInterface examPartServiceInterface;
	
	@GetMapping
	public ResponseEntity<List<ExamPartDTO>> getExamsByUser(@PathVariable("idExam") Long id){

		List<ExamPart> examParts = examPartServiceInterface.findAllByExam(id);
		
		List<ExamPartDTO> examPartDTO = new ArrayList<ExamPartDTO>();
		for(ExamPart examPart: examParts) {
			examPartDTO.add(new ExamPartDTO(examPart));
		}
		return new ResponseEntity<List<ExamPartDTO>>(examPartDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ExamPartDTO> getExamPart(@PathVariable("id") Long id){
		ExamPart examPart = examPartServiceInterface.findOne(id);
		
		if(examPart == null) {
			return new ResponseEntity<ExamPartDTO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ExamPartDTO>(new ExamPartDTO(examPart), HttpStatus.OK);
	}
	
	
	
	
}
