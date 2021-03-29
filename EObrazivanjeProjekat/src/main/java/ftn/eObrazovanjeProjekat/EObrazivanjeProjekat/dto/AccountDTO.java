package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto;

import java.util.HashSet;
import java.util.Set;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Student;

public class AccountDTO {
	
	private Long idAccount;
	private Double amount;
	private Student student;
	private Set<StudentPaymentsDTO> studentPayments = new HashSet<StudentPaymentsDTO>();
	
	public AccountDTO() {
		super();
	}
	
	public AccountDTO(Long idAccount,Double amount,Student student,Set<StudentPaymentsDTO> studentPayments) {
		super();
		this.idAccount = idAccount;
		this.amount = amount;
		this.student = student;
		this.studentPayments = studentPayments;
	}

	public Long getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(Long idAccount) {
		this.idAccount = idAccount;
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
