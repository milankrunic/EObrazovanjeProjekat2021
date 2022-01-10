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

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto.TeacherDTO;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Teacher;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.User;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.TeacherServiceInterface;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.UserServiceInterface;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "api/teacher")
public class TeacherController {

	@Autowired
	TeacherServiceInterface teacherServiceInterface;
	
	@Autowired
	UserServiceInterface userServiceInterface;

	@GetMapping
	@PreAuthorize("hasAnyRole('ROLE_ADMINISTRATOR')")
	public ResponseEntity<List<TeacherDTO>> getAllTeachers(){
		List<Teacher> teachers = teacherServiceInterface.findAll();
		
		List<TeacherDTO> teachersDTO = new ArrayList<TeacherDTO>();
		
		for (Teacher teacher : teachers) {
			teachersDTO.add(new TeacherDTO(teacher));
		}
		return new ResponseEntity<List<TeacherDTO>>(teachersDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	@PreAuthorize("hasAnyRole('ROLE_ADMINISTRATOR')")
	public ResponseEntity<TeacherDTO> getOneTeacher(@PathVariable("id") Long id){
		Teacher teacher = teacherServiceInterface.findById(id);
		if(teacher == null) {
			return new ResponseEntity<TeacherDTO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<TeacherDTO>(new TeacherDTO(teacher), HttpStatus.OK);
	}
	
	
	@PutMapping()
	@PreAuthorize("hasAnyRole('ROLE_TEACHER', 'ROLE_ADMINISTRATOR')")
	public ResponseEntity<TeacherDTO> updateTeacher(@RequestBody TeacherDTO teacherDTO){
		
		User user = userServiceInterface.findOne(teacherDTO.getUserDTO().getIdUser());
		Teacher teacher = teacherServiceInterface.findById(teacherDTO.getId());
		if(teacher == null) {
			return new ResponseEntity<TeacherDTO>(HttpStatus.NOT_FOUND);
		}
		teacher.setUser(user);
		teacherServiceInterface.save(teacher);
		return new ResponseEntity<TeacherDTO>(new TeacherDTO(teacher), HttpStatus.OK);	
	}
	
	@PostMapping
	@PreAuthorize("hasAnyRole('ROLE_ADMINISTRATOR')")
	public ResponseEntity<TeacherDTO> saveTeacher(@RequestBody TeacherDTO teacherDTO){
		User user = userServiceInterface.findOne(teacherDTO.getUserDTO().getIdUser());
		Teacher teacher = new Teacher();
		teacher.setUser(user);
		teacher = teacherServiceInterface.save(teacher);
		
		return new ResponseEntity<TeacherDTO>(new TeacherDTO(teacher), HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = "/{id}")
	@PreAuthorize("hasAnyRole('ROLE_ADMINISTRATOR')")
	public ResponseEntity<Void> deleteTeacher(@PathVariable("id") Long id){
		Teacher teacher = teacherServiceInterface.findById(id);
		if(teacher != null) {
			teacherServiceInterface.remove(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
}
