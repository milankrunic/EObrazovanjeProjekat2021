package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto;

import java.util.HashSet;
import java.util.Set;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Account;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Student;

public class AccountDTO {
	
	private Long idAccount;
	private Double amount;
	private Long student_id;
	private Set<StudentPaymentsDTO> studentPayments = new HashSet<StudentPaymentsDTO>();
	
	
	public AccountDTO(Account account) {
		this.idAccount = account.getIdAccount();
		this.amount = account.getAmount();
		this.student_id = account.getStudent().getIdStudent();
		

	}
	
	public AccountDTO(Long idAccount,Double amount,Long student_id,Set<StudentPaymentsDTO> studentPayments) {
		super();
		this.idAccount = idAccount;
		this.amount = amount;
		this.student_id = student_id;
		this.studentPayments = studentPayments;
	}

	
	
	public Long getStudent_id() {
		return student_id;
	}

	public void setStudent_id(Long student_id) {
		this.student_id = student_id;
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

//	public Student getStudent() {
//		return student;
//	}
//
//	public void setStudent(Student student) {
//		this.student = student;
//	}

	public Set<StudentPaymentsDTO> getStudentPayments() {
		return studentPayments;
	}

	public void setStudentPayments(Set<StudentPaymentsDTO> studentPayments) {
		this.studentPayments = studentPayments;
	}
	
	
}
