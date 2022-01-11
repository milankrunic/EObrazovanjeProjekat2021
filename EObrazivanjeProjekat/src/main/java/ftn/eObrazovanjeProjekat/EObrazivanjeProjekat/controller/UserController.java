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
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Student;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Teacher;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.User;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.UserRole;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.security.TokenUtils;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.service.UserDetailsServiceImpl;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.AdminServiceInterface;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.StudentServiceInterface;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.TeacherServiceInterface;
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
	
	
//	put i videti za signup tj za post!!!
	
//	@PutMapping(value = "/")
//	@PreAuthorize("hasAnyRole('ROLE_STUDENT', 'ROLE_ADMINISTRATOR')")
//	@Transactional
//	public ResponseEntity<UserDTO> updateStudent(@RequestBody UserDTO userDTO){
//		User user = userService.findByUsername(userDTO.getUser_name());
//		System.out.println("\nFirst name: "+userDTO.getFirstName());
//		if(user == null) {
//			return new ResponseEntity<UserDTO>(HttpStatus.NOT_FOUND);
//		}
//		List<UserRole> userRoles = new ArrayList<UserRole>();
////		for (UserRole userRole : user.getUserRoles()) {
////			userRoleS.deleteUserRole(userRole);
////		}
//		for(UserRole r:user.getUserRoles()) {
//			if(r.getRole().getCode().equals("st")) {
//				Student s = studentService.findByUser(user.getUsername());
//				System.out.println("\nroleToString "+userDTO.roleToString());
//				System.out.println("r.getRole().getCode() "+r.getRole().getCode());
//				System.out.println("Da li tacno? "+userDTO.roleToString().contains(r.getRole().getCode()));
//				if(s!=null && !userDTO.roleToString().contains(r.getRole().getCode())) {	
//					System.out.println("\nBrisem studenta");
//					studentService.remove(s.getIdStudent());
//				}
//			}else if(r.getRole().getCode().equals("admin")) {
//				Admin a = adminService.findByUser(user.getUsername());
//				if(a!=null && !userDTO.roleToString().contains(r.getRole().getCode())) {
//					adminService.remove(a.getIdAdmin());
//				}
//			}else if(r.getRole().getCode().equals("teach") ) {
//				Teacher teacher = teacherService.findByUsername(user.getUsername());;
//				if(teacher!=null && !userDTO.roleToString().contains(r.getRole().getCode())) {
//					System.out.println("\nBrisem teachera");
//					teacherService.remove(teacher.getIdTeacher());
//				} 
//			}
//		}
		
//		userRoles.deleteByUser(user.getId());
//		user.setFirstName(userDTO.getFirstName());
//		user.setLastName(userDTO.getLastName());
//		if(!userDTO.getPassword().equals(user.getPassword())) {
//			user.setPassword(passwordEncoder.encode(userDTO.getPassword()));	
//		}
//		user.setUserRoles(userRoles);
//		System.out.println("\nPukao2");
//		for (RoleDTO roleDTO : userDTO.getRoles()) {
//			Role r = roleS.findByCode(roleDTO.getCode());
//			UserRole userRole = new UserRole(user,r);
//			user.getUserRoles().add(userRole);
//			if(roleDTO.getCode().equals("st")) {
//				Student student = studentS.findByUser(user.getUsername());
//				if(student==null) {
//					student = new Student();
//					Date date = new Date();
//					Calendar calendar = Calendar.getInstance();
//					calendar.setTime(date);
//					String cardNumber = "S-"+studentS.maxId()+"-"+calendar.get(Calendar.YEAR);
//					student.setCardNumber(cardNumber);
//					student.setUser(user);
//					studentS.save(student);
//					
//					Account account = new Account();
//					account.setStudent(student);
//					accountS.save(account);
//				}
//			}else if(roleDTO.getCode().equals("teach")) {
//				Teacher teacher = teachS.findByUsername(user.getUsername());
//				if(teacher==null) {
//					teacher = new Teacher();
//					teacher.setUser(user);
//					teachS.save(teacher);
//				}
//			}else if(roleDTO.getCode().equals("admin")) {
//				Administrator admin = adminS.findByUser(user.getUsername());
//				if(admin==null) {
//					admin = new Administrator();
//					admin.setUser(user);
//					adminS.save(admin);
//				}
//			}
//			user = userService.save(user);
//		}
//		
//		return ResponseEntity.ok().build();
//	}
//	
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

