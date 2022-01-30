package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;
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
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.exceptions.BadRequestException;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Admin;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Document;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Role;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Student;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Teacher;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.User;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.UserRole;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.security.TokenUtils;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.service.UserDetailsServiceImpl;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.service.UserRoleService;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.AdminServiceInterface;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.RoleServiceInterface;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.StudentServiceInterface;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.TeacherServiceInterface;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.UserRoleServiceInterface;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.UserServiceInterface;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto.RoleDTO;

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
	
	@Autowired
	private UserRoleServiceInterface userRoleServiceInterface;
	
	@Autowired
	private RoleServiceInterface roleService;
	
	
	@Autowired
	private StudentServiceInterface studentService;
	
	@Autowired
	private AdminServiceInterface adminService;
	
	@Autowired
	private TeacherServiceInterface teacherService;
	
	
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
            System.out.println("token" + t.getValue());
            return new ResponseEntity<JwtDTO>(t, HttpStatus.OK);
        } catch (Exception ex) {
            return ResponseEntity.status(401).build();
        }
	}
	
	@GetMapping(value = "/logout", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> logoutUser() {
		System.out.println("\nLog out!");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (!(auth instanceof AnonymousAuthenticationToken)){
            SecurityContextHolder.clearContext();

            return new ResponseEntity<>("You successfully logged out!", HttpStatus.OK);
        } else {
            throw new BadRequestException("User is not authenticated!");
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
	
	
	
	@GetMapping(value = "/{username}/unassigned-roles")
	public ResponseEntity<List<RoleDTO>> getRoles(@PathVariable("username") String username){
		User user = userService.findByUsername(username);
		
		List<RoleDTO> rolesDTO = new ArrayList<RoleDTO>();
		List<Role> allRole= roleService.findAll();
		
		if(user != null && user.getUserRoles().size()>0) {
			for (Role role : allRole) {
				int isIn = 0;
				for (UserRole userRole: user.getUserRoles()) {
					if(!userRole.getRole().getCode().equals(role.getCode())) {
						System.out.println("Rola: "+role.getName()+" ne postoji kod korisnika: "+user.getUsername());
						isIn ++;
					}
				}
				System.out.println("\nIs IN: "+isIn);
				System.out.println("Size userRoles: "+user.getUserRoles().size());
				if(isIn==user.getUserRoles().size()) {
					System.out.println("Prosao\n");
					rolesDTO.add(new RoleDTO(role));
				}
			}
		}else if ((user == null) || user.getUserRoles().size()==0){
			for (Role role : allRole) {
				rolesDTO.add(new RoleDTO(role));
			}
		}
		
		return new ResponseEntity<List<RoleDTO>>(rolesDTO, HttpStatus.OK);
	}
	@GetMapping(value = "/loggedUser")
	public ResponseEntity<UserDTO> getLoggedUser(Principal principal){
		
		System.out.println(principal.getName() + " user get id");
		User user = userService.findByUsername(principal.getName());
		
		if(user == null) {
			System.out.println("user je null");
			return new ResponseEntity<UserDTO>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<UserDTO>(new UserDTO(user), HttpStatus.OK);
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

