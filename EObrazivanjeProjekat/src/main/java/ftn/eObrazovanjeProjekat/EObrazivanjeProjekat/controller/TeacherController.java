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

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto.TeacherDTO;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Teacher;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.User;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.TeacherServiceInterface;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.UserServiceInterface;

@RestController
@RequestMapping(value = "api/teacher")
public class TeacherController {

	@Autowired
	TeacherServiceInterface teacherServiceInterface;
	
	@Autowired
	UserServiceInterface userServiceInterface;
	
	@GetMapping
	public ResponseEntity<List<TeacherDTO>> getTeacher(){

		List<Teacher> teachers = teacherServiceInterface.findAll();
		
		List<TeacherDTO> teacherDTO = new ArrayList<TeacherDTO>();
		for(Teacher tea: teachers) {
			teacherDTO.add(new TeacherDTO(tea));
		}
		return new ResponseEntity<List<TeacherDTO>>(teacherDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<TeacherDTO> getTeacher(@PathVariable("id") Long id){
		Teacher teacher = teacherServiceInterface.findOne(id);
		
		if(teacher == null) {
			return new ResponseEntity<TeacherDTO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<TeacherDTO>(new TeacherDTO(teacher), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<TeacherDTO> addTeacher(@RequestBody TeacherDTO teacherDTO){

		User u = userServiceInterface.findById(teacherDTO.getIdUser());
		Teacher t = new Teacher();
		t.setFirstName(teacherDTO.getFirstName());	
		t.setLastName(teacherDTO.getLastName());
		t.setEmail(teacherDTO.getEmail());
		t.setUser(u);
		
		t = teacherServiceInterface.save(t);
		return new ResponseEntity<TeacherDTO>(new TeacherDTO(t), HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}", consumes = "application/json")
	public ResponseEntity<TeacherDTO> updateTeacher(@RequestBody TeacherDTO teacherDTO, @PathVariable("id") Long id){

		Teacher teacher = teacherServiceInterface.findById(id);
		User user = userServiceInterface.findById(teacherDTO.getIdUser());
		
		if(teacher == null) {
			return new ResponseEntity<TeacherDTO>(HttpStatus.BAD_REQUEST);
		}
		teacher.setFirstName(teacherDTO.getFirstName());
		teacher.setLastName(teacherDTO.getLastName());
		teacher.setEmail(teacherDTO.getEmail());
		teacher.setUser(user);

		return new ResponseEntity<TeacherDTO>(new TeacherDTO(teacher), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteTeacher(@PathVariable("id") Long id){
		Teacher teacher = teacherServiceInterface.findById(id);
		if(teacher != null) {
			teacherServiceInterface.remove(id);
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
}
