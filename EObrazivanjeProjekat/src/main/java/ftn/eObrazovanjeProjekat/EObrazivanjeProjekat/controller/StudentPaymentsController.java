package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto.StudentPaymentsDTO;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.StudentPayments;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.StudentPaymentsServiceInterface;

@RestController
@RequestMapping(value = "api/payments")
public class StudentPaymentsController {
	
	@Autowired
	StudentPaymentsServiceInterface studentPaymentsServiceInterface;
	

	@GetMapping(value = "{id}")
	public ResponseEntity<StudentPaymentsDTO> getPaymentByAccountId(@PathVariable("id") Long id){
		
		StudentPayments payments = (StudentPayments) studentPaymentsServiceInterface.findByAccountId(id);
		
		if(payments == null) {
			return new ResponseEntity<StudentPaymentsDTO>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<StudentPaymentsDTO>(new StudentPaymentsDTO(payments),HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletePayment(@PathVariable("id") Long id){
		
		StudentPayments payments = studentPaymentsServiceInterface.findOne(id);
		if(payments != null) {
			studentPaymentsServiceInterface.remove(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); 
	}
	
	
}
