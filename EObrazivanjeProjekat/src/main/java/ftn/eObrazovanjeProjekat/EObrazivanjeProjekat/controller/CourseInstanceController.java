package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto.CourseInstanceDTO;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto.CourseSpecificationDTO;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.CourseInstance;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.CourseSpecification;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.CourseInstanceServiceInterface;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.CourseSpecificationServiceInterface;
import ftn.projekat.eObrazovanje.ProjekatEObrazovanje20212022.serviceInterface.CourseInstanceI;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "api/course-instance")
public class CourseInstanceController {
	
	@Autowired
	CourseInstanceServiceInterface courseInstanceServiceInterface;
	
	@Autowired
	CourseSpecificationServiceInterface courseSpecificationServiceInterface;
	
		
	@GetMapping
	public ResponseEntity<List<CourseInstanceDTO>> getAllCourseInstance(){

		List<CourseInstance> courseInstances = courseInstanceServiceInterface.findAll();
		
		List<CourseInstanceDTO> courseInstanceDTO = new ArrayList<CourseInstanceDTO>();
		for(CourseInstance ci: courseInstances) {
			courseInstanceDTO.add(new CourseInstanceDTO(ci));
		}
		return new ResponseEntity<List<CourseInstanceDTO>>(courseInstanceDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/number-course-instance")
	public ResponseEntity<Long> getNumberPage(@RequestParam String mode,@RequestParam String username){
		System.out.println("\nPoziva se number-course-instance: "+mode+" "+username);
		Long num = (long)0;
		if(mode.equals("ADMIN")) {
			num = courseInstanceServiceInterface.countAll()/5;
			Long mod = courseInstanceServiceInterface.countAll()%5;
			if(mod>0) {
				num ++;
			}
		}else if(mode.equals("TEACHER")) {
			num = courseInstanceServiceInterface.countForTeacher(username)/5;
			System.out.println("\nNum: "+num);
			Long mod = courseInstanceServiceInterface.countForTeacher(username)%5;
			System.out.println("\nMod: "+mod);
			if(mod>0) {
				num ++;
			}
		}else if(mode.equals("STUDENT")) {
			num = courseInstanceServiceInterface.countForStudent(username)/5;
			System.out.println("\nNum: "+num);
			Long mod = courseInstanceServiceInterface.countForStudent(username)%5;
			System.out.println("\nMod: "+mod);
			if(mod>0) {
				num ++;
			}
		}
		return new ResponseEntity<Long>(num, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CourseInstanceDTO> getCourseInstance(@PathVariable("id") Long id){
		CourseInstance ci = courseInstanceServiceInterface.findById(id);
		
		if(ci == null) {
			return new ResponseEntity<CourseInstanceDTO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<CourseInstanceDTO>(new CourseInstanceDTO(ci), HttpStatus.OK);
	}
	
	@PostMapping
	@PreAuthorize("hasAnyRole('ROLE_TEACHER', 'ROLE_ADMINISTRATOR')")
	public ResponseEntity<CourseInstanceDTO> addCourseInstance(@RequestBody CourseInstanceDTO courseInstanceDTO){

		CourseSpecification cs = courseSpecificationServiceInterface.findById(courseInstanceDTO.getCourseSpecificationDTO().getIdCourseSpecification());
		
		CourseInstance ci = new CourseInstance();
		ci.setIdCourseInstance(courseInstanceDTO.getIdCourseInstance());
		ci.setStartDate(courseInstanceDTO.getStartDate());
		ci.setEndDate(courseInstanceDTO.getEndDate());
		ci.setCourseSpecification(cs);
		
		ci = courseInstanceServiceInterface.save(ci);
		return new ResponseEntity<CourseInstanceDTO>(new CourseInstanceDTO(ci), HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}", consumes = "application/json")
	@PreAuthorize("hasAnyRole('ROLE_TEACHER', 'ROLE_ADMINISTRATOR')")
	public ResponseEntity<CourseInstanceDTO> updateCourseInstance(@RequestBody CourseInstanceDTO courseInstanceDTO, @PathVariable("id") Long id){

		CourseSpecification cs = courseSpecificationServiceInterface.findById(courseInstanceDTO.getCourseSpecificationDTO().getIdCourseSpecification());
	
		
		CourseInstance courseInstance = courseInstanceServiceInterface.findById(id);
		
		if(courseInstance == null) {
			return new ResponseEntity<CourseInstanceDTO>(HttpStatus.BAD_REQUEST);
		}
		courseInstance.setIdCourseInstance(courseInstanceDTO.getIdCourseInstance());
		courseInstance.setStartDate(courseInstanceDTO.getStartDate());
		courseInstance.setEndDate(courseInstanceDTO.getEndDate());
		courseInstance.setCourseSpecification(cs);
		

		courseInstance = courseInstanceServiceInterface.save(courseInstance);
		return new ResponseEntity<CourseInstanceDTO>(new CourseInstanceDTO(courseInstance), HttpStatus.OK);
	}
	
//	@GetMapping(value = "/all/for-student/{username}")
//	public ResponseEntity<List<CourseInstanceDTO>> getAllByStudent(@PathVariable("username") String username){
//		List<CourseInstance> cis = courseInstanceServiceInterface.findByStudent(username);
//		
//		System.out.println("cis for student: " + cis);
//		
//		List<CourseInstanceDTO> cisdto = new ArrayList<CourseInstanceDTO>();
//		
//		for(CourseInstance ci : cis) {
//			cisdto.add(new CourseInstanceDTO(ci));
//		}
//		return new ResponseEntity<List<CourseInstanceDTO>>(cisdto, HttpStatus.OK);
//	}
	
	@DeleteMapping(value = "/{id}")
	@PreAuthorize("hasAnyRole('ROLE_TEACHER', 'ROLE_ADMINISTRATOR')")
	public ResponseEntity<Void> deleteCourseInstance(@PathVariable("id") Long id){
		CourseInstance ci = courseInstanceServiceInterface.findById(id);
		if(ci != null) {
			courseInstanceServiceInterface.remove(id);
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

}
