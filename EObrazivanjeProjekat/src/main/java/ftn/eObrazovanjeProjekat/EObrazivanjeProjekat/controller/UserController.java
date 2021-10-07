package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto.DocumentDTO;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto.JwtDTO;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto.LoginDTO;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto.TeacherDTO;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto.UserDTO;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Document;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Teacher;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.User;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.security.TokenUtils;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.service.UserDetailsServiceImpl;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.UserServiceInterface;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "api/users")
public class UserController {
	
	@Autowired
	TokenUtils tokenUtils;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	private UserServiceInterface userService;
	
	
	@SuppressWarnings("unused")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<JwtDTO> login(@RequestBody LoginDTO loginDTO) {
		System.out.println("\nLOGIN");
        try {
        	// imamo request i response klase(jwt dto i login dto)  	 
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
					loginDTO.getUsername(), loginDTO.getPassword());
            Authentication authentication = authenticationManager.authenticate(token);
            UserDetails details = userDetailsService.loadUserByUsername(loginDTO.getUsername());
            // ovde generisemo token pomocu detalja koje smo dobili iz funkcije iznad
            JwtDTO t = new JwtDTO(tokenUtils.generateToken(details));
            //vracamo generisan token
            return new ResponseEntity<JwtDTO>(t, HttpStatus.OK);
        } catch (Exception ex) {
            return ResponseEntity.status(401).build();
        }
	}

	
	@GetMapping
	public ResponseEntity<List<UserDTO>> getUsers() {
		List<User> users = userService.findAll();
		List<UserDTO> usersDTO = new ArrayList<UserDTO>();
		for (User u : users) {
			usersDTO.add(new UserDTO(u));
		}
		return new ResponseEntity<List<UserDTO>>(usersDTO, HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<UserDTO> getUser(@PathVariable("id") Long id){
		User user = userService.findOne(id);
		if(user == null){
			return new ResponseEntity<UserDTO>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<UserDTO>(new UserDTO(user), HttpStatus.OK);
	}
	
	
	
	

	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO){
		
		User user = new User();
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		user.setUsername(userDTO.getUser_name());
		user.setPassword(userDTO.getPassword());
		
		user = userService.save(user);
		return new ResponseEntity<UserDTO>(new UserDTO(user),HttpStatus.CREATED);
	}
	

	
	@PutMapping(value ="/{id}",consumes = "application/json")
	public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO,@PathVariable("id") Long id){
		
		User user = userService.findOne(id);
		
		if(user == null) {
			return new ResponseEntity<UserDTO>(HttpStatus.BAD_REQUEST);
		}
		
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		user.setEmail(userDTO.getEmail());
		user.setUsername(userDTO.getUser_name());
		user.setPassword(userDTO.getPassword());
		
		user = userService.save(user);
		
		return new ResponseEntity<UserDTO>(new UserDTO(user),HttpStatus.OK);
	}
	
	
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id){
		User user = userService.findOne(id);
		if (user != null){
			userService.remove(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
}

