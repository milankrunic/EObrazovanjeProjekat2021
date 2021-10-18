package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.controller;



import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RestController;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto.AccountDTO;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Account;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Student;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.AccountServiceInterface;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.StudentServiceInterface;

@RestController
@RequestMapping(value = "api/account")
public class AccountController {
	
	@Autowired
	StudentServiceInterface studentService;
	
	@Autowired
	AccountServiceInterface accountServiceInterface;

	
	@GetMapping(value = "/one-account")
	@PreAuthorize("hasAnyRole('ROLE_STUDENT', 'ROLE_ADMINISTRATOR')")
	public ResponseEntity<AccountDTO> getOneAccount(Principal principal){
		Account account = accountServiceInterface.findByUsername(principal.getName()).get(0);
		if(account == null) {
			return new ResponseEntity<AccountDTO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<AccountDTO>(new AccountDTO(account), HttpStatus.OK);
	}
	
	@GetMapping()
	@PreAuthorize("hasAnyRole('ROLE_STUDENT', 'ROLE_ADMINISTRATOR')")
	public ResponseEntity<AccountDTO> getAccountsByStudent(Principal principal){
		List<Account> accounts = accountServiceInterface.findByUsername(principal.getName());
		if(accounts.size() == 0) {
			return new ResponseEntity<AccountDTO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<AccountDTO>(new AccountDTO(accounts.get(0)), HttpStatus.OK);
	}
	
	@PutMapping()
	@PreAuthorize("hasAnyRole('ROLE_STUDENT', 'ROLE_ADMINISTRATOR')")
	public ResponseEntity<AccountDTO> updateAccount(@RequestBody AccountDTO accountDTO){
		
		Student student = studentService.findById(accountDTO.getStudentDTO().getId());
		
		Account acc = accountServiceInterface.findOne(accountDTO.getId());
		if(acc == null) {
			return new ResponseEntity<AccountDTO>(HttpStatus.NOT_FOUND);
		}
		acc.setAmount(accountDTO.getAmount());
		acc.setStudent(student);
		acc = accountServiceInterface.save(acc);
		return new ResponseEntity<AccountDTO>(new AccountDTO(acc), HttpStatus.OK);
	}
	
	@PostMapping
	@PreAuthorize("hasAnyRole('ROLE_STUDENT', 'ROLE_ADMINISTRATOR')")
	public ResponseEntity<AccountDTO> saveAccount(@RequestBody AccountDTO accountDTO){
		Student student = studentService.findById(accountDTO.getStudentDTO().getId());
		
		Account account = new Account();
		account.setAmount(accountDTO.getAmount());
		account.setStudent(student);
		
		account = accountServiceInterface.save(account);
		
		return new ResponseEntity<AccountDTO>(new AccountDTO(account), HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = "/{id}")
	@PreAuthorize("hasAnyRole('ROLE_STUDENT', 'ROLE_ADMINISTRATOR')")
	public ResponseEntity<Void> deleteAccount(@PathVariable("id") Long id){
		Account account = accountServiceInterface.findOne(id);
		if(account != null) {
			accountServiceInterface.remove(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
}
