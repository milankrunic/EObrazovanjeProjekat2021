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

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto.CourseSpecificationDTO;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.CourseSpecification;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.CourseSpecificationServiceInterface;


@RestController
@RequestMapping(value = "api/course_specification")
public class CourseSpecificationController {
	
	@Autowired
	CourseSpecificationServiceInterface courseSpecificationServiceInterface;
	
	@GetMapping
	public ResponseEntity<List<CourseSpecificationDTO>> getCourseSpecification(){

		List<CourseSpecification> courseSpecifications = courseSpecificationServiceInterface.findAll();
		
		List<CourseSpecificationDTO> courseSpecificationDTO = new ArrayList<CourseSpecificationDTO>();
		for(CourseSpecification cs: courseSpecifications) {
			courseSpecificationDTO.add(new CourseSpecificationDTO(cs));
		}
		return new ResponseEntity<List<CourseSpecificationDTO>>(courseSpecificationDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CourseSpecificationDTO> getCourseSpecification(@PathVariable("id") Long id){
		CourseSpecification courseSpecification = courseSpecificationServiceInterface.findById(id);
		
		if(courseSpecification == null) {
			return new ResponseEntity<CourseSpecificationDTO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<CourseSpecificationDTO>(new CourseSpecificationDTO(courseSpecification), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<CourseSpecificationDTO> addCourseSpecification(@RequestBody CourseSpecificationDTO courseSpecificationDTO){

		CourseSpecification cs = new CourseSpecification();
		cs.setIdCourseSpecification(courseSpecificationDTO.getIdCourseSpecification());
		cs.setTitle(courseSpecificationDTO.getTitle());
		cs.setEcts(courseSpecificationDTO.getEcts());
		cs.setCode(courseSpecificationDTO.getCode());
		
		cs = courseSpecificationServiceInterface.save(cs);
		return new ResponseEntity<CourseSpecificationDTO>(new CourseSpecificationDTO(cs), HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}", consumes = "application/json")
	public ResponseEntity<CourseSpecificationDTO> updateCourseSpecification(@RequestBody CourseSpecificationDTO courseSpecificationDTO, @PathVariable("id") Long id){

		CourseSpecification courseSpecification = courseSpecificationServiceInterface.findById(id);
		
		if(courseSpecification == null) {
			return new ResponseEntity<CourseSpecificationDTO>(HttpStatus.BAD_REQUEST);
		}
		courseSpecification.setIdCourseSpecification(courseSpecificationDTO.getIdCourseSpecification());
		courseSpecification.setTitle(courseSpecificationDTO.getTitle());
		courseSpecification.setEcts(courseSpecificationDTO.getEcts());
		courseSpecification.setCode(courseSpecificationDTO.getCode());

		courseSpecification = courseSpecificationServiceInterface.save(courseSpecification);
		return new ResponseEntity<CourseSpecificationDTO>(new CourseSpecificationDTO(courseSpecification), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteCourseSpecification(@PathVariable("id") Long id){
		CourseSpecification cs = courseSpecificationServiceInterface.findById(id);
		if(cs != null) {
			courseSpecificationServiceInterface.remove(id);
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

}
