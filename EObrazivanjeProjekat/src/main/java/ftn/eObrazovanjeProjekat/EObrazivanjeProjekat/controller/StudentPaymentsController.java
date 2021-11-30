package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto.StudentPaymentsDTO;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Account;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.StudentPayments;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.AccountServiceInterface;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.StudentPaymentsServiceInterface;




@RestController
@RequestMapping(value = "api/payments")
public class StudentPaymentsController {
	
	@Autowired
	StudentPaymentsServiceInterface studentPaymentsServiceInterface;
	
	@Autowired
	AccountServiceInterface accountServiceInterface;
	

	@GetMapping
	@PreAuthorize("hasAnyRole('ROLE_STUDENT', 'ROLE_ADMINISTRATOR')")
	public ResponseEntity<List<StudentPaymentsDTO>> getAllPaymentsByStudent(Principal principal,Pageable page){
		Page<StudentPayments> payments = studentPaymentsServiceInterface.findByUsername(principal.getName(),page);
		
		List<StudentPaymentsDTO> dtos = new ArrayList<StudentPaymentsDTO>();
		
		for(StudentPayments p : payments) {
			dtos.add(new StudentPaymentsDTO(p));
		}
		
		return new ResponseEntity<List<StudentPaymentsDTO>>(dtos, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")//IZMJENITII 	
	public ResponseEntity<StudentPaymentsDTO> getOnePayment(@PathVariable("id") Long id){
		StudentPayments p = studentPaymentsServiceInterface.findOne(id);
		if(p == null) {
			return new ResponseEntity<StudentPaymentsDTO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<StudentPaymentsDTO>(new StudentPaymentsDTO(p), HttpStatus.OK);
	}
	
	
	@PostMapping
	@PreAuthorize("hasAnyRole('ROLE_STUDENT', 'ROLE_ADMINISTRATOR')")
	public ResponseEntity<StudentPaymentsDTO> savePayment(@RequestBody StudentPaymentsDTO dto, Principal principal){
		System.out.println("\nsavePayment");
//		System.out.println("Username: "+username);
		String u = principal.getName();
		
		Account account = accountServiceInterface.findByUsername(u).get(0);
		StudentPayments p = new StudentPayments();
		p.setAccount(account);
		p.setAmount(dto.getAmount());
		p.setDate(dto.getDate());
		p.setName(dto.getName());

		account.setAmount(account.getAmount() + p.getAmount());
		accountServiceInterface.save(account);
		p = studentPaymentsServiceInterface.save(p);
		
		return new ResponseEntity<StudentPaymentsDTO>(new StudentPaymentsDTO(p), HttpStatus.CREATED);
	}
	
	@PutMapping()
	public ResponseEntity<StudentPaymentsDTO> updatePayment(@RequestBody StudentPaymentsDTO dto){
		
		Account account = accountServiceInterface.findOne(dto.getAccountDTO().getId());
		StudentPayments p = studentPaymentsServiceInterface.findOne(dto.getId());
		
		if(p == null) {
			return new ResponseEntity<StudentPaymentsDTO>(HttpStatus.NOT_FOUND);
		}
		account.setAmount(account.getAmount()-p.getAmount());
		p.setAmount(dto.getAmount());
		account.setAmount(account.getAmount()+p.getAmount());
		
		
		accountServiceInterface.save(account);
		p = studentPaymentsServiceInterface.save(p);
		
		return new ResponseEntity<StudentPaymentsDTO>(new StudentPaymentsDTO(p), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	@PreAuthorize("hasAnyRole('ROLE_ADMINISTRATOR')")
	public ResponseEntity<Void> deletePayment(@PathVariable("id") Long id){
		
		StudentPayments payments = studentPaymentsServiceInterface.findOne(id);
		if(payments != null) {
			studentPaymentsServiceInterface.remove(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); 
	}
	
	
}
