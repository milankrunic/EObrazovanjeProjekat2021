package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RestController;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto.AdminDTO;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Admin;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.User;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.AdminServiceInterface;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.UserServiceInterface;

@CrossOrigin(origins = "http://localhost:4200")
@RestController 
@RequestMapping(value = "api/admin")
public class AdminController {
	
	@Autowired
	AdminServiceInterface adminServiceInterface;
	
	@Autowired
	UserServiceInterface userServiceInterface;

	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_ADMINISTRATOR')")
	public ResponseEntity<List<AdminDTO>> getAdmins() {
		List<Admin> admins = adminServiceInterface.findAllAdmin();
		
		List<AdminDTO> adminDTO = new ArrayList<AdminDTO>();
		for(Admin adm : admins) {
			adminDTO.add(new AdminDTO(adm));
		}
		return new ResponseEntity<List<AdminDTO>>(adminDTO, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/{idAdmin}")
	@PreAuthorize("hasAnyRole('ROLE_ADMINISTRATOR')")
	public ResponseEntity<AdminDTO> getAdmin(@PathVariable("idAdmin") Long idAdmin){
		Admin admin = adminServiceInterface.findOneAdmin(idAdmin);
		
		if(admin == null) {
			return new ResponseEntity<AdminDTO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<AdminDTO>(new AdminDTO(admin), HttpStatus.OK);
	}
	
	
	@PostMapping
	public ResponseEntity<AdminDTO> addAdmin(@RequestBody AdminDTO adminDTO){

		User u = userServiceInterface.findOne(adminDTO.getIdUser());
		Admin a = new Admin();
//		a.setEmail(adminDTO.getEmail());
		a.setUser(u);
		
		a = adminServiceInterface.saveAdmin(a);
		return new ResponseEntity<AdminDTO>(new AdminDTO(a), HttpStatus.CREATED);
	}
	
	
	@PutMapping(value = "/{idAdmin}", consumes = "application/json")
	public ResponseEntity<AdminDTO> updateAdmin(@RequestBody AdminDTO adminDTO, @PathVariable("idAdmin") Long idAdmin){

		Admin admin = adminServiceInterface.findById(idAdmin);
		User user = userServiceInterface.findOne(adminDTO.getIdUser());
		
		if(admin == null) {
			return new ResponseEntity<AdminDTO>(HttpStatus.BAD_REQUEST);
		}

//		admin.setEmail(adminDTO.getEmail());
		admin.setUser(user);

		admin = adminServiceInterface.saveAdmin(admin);
		return new ResponseEntity<AdminDTO>(new AdminDTO(admin), HttpStatus.OK);
	}
	
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteAdmin(@PathVariable("id") Long id){
		Admin admin = adminServiceInterface.findById(id);
		if(admin != null) {
			adminServiceInterface.remove(id);
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
}
