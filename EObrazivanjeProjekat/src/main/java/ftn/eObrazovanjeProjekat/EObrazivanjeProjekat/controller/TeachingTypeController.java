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

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto.TeachingTypeDTO;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.TeachingType;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.TeachingTypeServiceInterface;

@RestController
@RequestMapping(value = "api/teaching_type")
public class TeachingTypeController {
	
	@Autowired
	TeachingTypeServiceInterface teachingTypeServiceInterface;
	
	@GetMapping
	public ResponseEntity<List<TeachingTypeDTO>> getTeachingType(){

		List<TeachingType> teachingTypes = teachingTypeServiceInterface.findAll();
		
		List<TeachingTypeDTO> teachingTypeDTO = new ArrayList<TeachingTypeDTO>();
		for(TeachingType tt: teachingTypes) {
			teachingTypeDTO.add(new TeachingTypeDTO(tt));
		}
		return new ResponseEntity<List<TeachingTypeDTO>>(teachingTypeDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<TeachingTypeDTO> getTeachingType(@PathVariable("id") Long id){
		TeachingType tt = teachingTypeServiceInterface.findById(id);
		
		if(tt == null) {
			return new ResponseEntity<TeachingTypeDTO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<TeachingTypeDTO>(new TeachingTypeDTO(tt), HttpStatus.OK);
	}

}
