package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto;

import java.util.HashSet;
import java.util.Set;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Account;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Student;
import ftn.projekat.eObrazovanje.ProjekatEObrazovanje20212022.dtos.StudentDTO;

public class AccountDTO {
	
	private Long id;
	private Double amount;
	private Student student;
	private Set<StudentPaymentsDTO> studentPayments = new HashSet<StudentPaymentsDTO>();
	
	public AccountDTO() {
		super();
	}
	
	public AccountDTO(Long id,Double amount,Student student,Set<StudentPaymentsDTO> studentPayments) {
		super();
		this.id = id;
		this.amount = amount;
		this.student = student;
		this.studentPayments = studentPayments;
	}
	
	public AccountDTO(Account account) {
		this(account.getId(),account.getAmount(),account.getStudent(),account.getStudentPayments());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Set<StudentPaymentsDTO> getStudentPayments() {
		return studentPayments;
	}

	public void setStudentPayments(Set<StudentPaymentsDTO> studentPayments) {
		this.studentPayments = studentPayments;
	}
	
	
}
