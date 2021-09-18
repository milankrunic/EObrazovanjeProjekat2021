package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto.TeachingDTO;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.CourseInstance;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Teacher;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Teaching;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.TeachingType;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.CourseInstanceServiceInterface;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.TeacherServiceInterface;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.TeachingServiceInterface;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.TeachingTypeServiceInterface;

@RestController
@RequestMapping(value = "api/teaching")
public class TeachingController {
	
	@Autowired
	TeachingServiceInterface teachingServiceInterface;
	
	@Autowired
	CourseInstanceServiceInterface courseInstanceServiceInterface;
	
	@Autowired
	TeacherServiceInterface teacherServiceInterface;
	
	@Autowired
	TeachingTypeServiceInterface teachingTypeServiceInterface;
	
	@GetMapping
	public ResponseEntity<List<TeachingDTO>> getTeaching(){

		List<Teaching> teaching = teachingServiceInterface.findAll();
		
		List<TeachingDTO> teachingDTO = new ArrayList<TeachingDTO>();
		for(Teaching te: teaching) {
			teachingDTO.add(new TeachingDTO(te));
		}
		return new ResponseEntity<List<TeachingDTO>>(teachingDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<TeachingDTO> getTeaching(@PathVariable("id") Long id){
		Teaching teaching = teachingServiceInterface.findById(id);
		
		if(teaching == null) {
			return new ResponseEntity<TeachingDTO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<TeachingDTO>(new TeachingDTO(teaching), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<TeachingDTO> addTeaching(@RequestBody TeachingDTO teachingDTO){

		CourseInstance ci = courseInstanceServiceInterface.findById(teachingDTO.getCourseInstance().getIdCourseInstance());
		Teacher t = teacherServiceInterface.findById(teachingDTO.getTeacher().getId());
		TeachingType tt = teachingTypeServiceInterface.findById(teachingDTO.getTeachingType().getIdTeachingType());
		
		
		Teaching tea = new Teaching();
		
		tea.setIdTeaching(teachingDTO.getIdTeaching());
		tea.setCourseInstance(ci);
		tea.setTeacher(t);
		tea.setTeachingType(tt);
		
		tea = teachingServiceInterface.save(tea);
		return new ResponseEntity<TeachingDTO>(new TeachingDTO(tea), HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}", consumes = "application/json")
	public ResponseEntity<TeachingDTO> updateTeaching(@RequestBody TeachingDTO teachingDTO, @PathVariable("id") Long id){

		CourseInstance ci = courseInstanceServiceInterface.findById(teachingDTO.getCourseInstance().getIdCourseInstance());
		Teacher t = teacherServiceInterface.findById(teachingDTO.getTeacher().getId());
		TeachingType tt = teachingTypeServiceInterface.findById(teachingDTO.getTeachingType().getIdTeachingType());
		
		Teaching tea = teachingServiceInterface.findById(id);
		
		if(tea == null) {
			return new ResponseEntity<TeachingDTO>(HttpStatus.BAD_REQUEST);
		}
		tea.setIdTeaching(teachingDTO.getIdTeaching());
		tea.setCourseInstance(ci);
		tea.setTeacher(t);
		tea.setTeachingType(tt);

		tea = teachingServiceInterface.save(tea);
		return new ResponseEntity<TeachingDTO>(new TeachingDTO(tea), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteTeaching(@PathVariable("id") Long id){
		Teaching teaching = teachingServiceInterface.findById(id);
		if(teaching != null) {
			teachingServiceInterface.remove(id);
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

}
