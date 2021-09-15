package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto;

import java.util.HashSet;
import java.util.Set;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Student;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Teacher;

public class StudentDTO {
	
	private Long id;
	private String firstName;
	private String lastName;
	private String email; 
	private String cardNumber;
	private Long userId;
	private String user;
//	private Set<EnrollmentDTO> enrollments = new HashSet<EnrollmentDTO>();
//	private Set<DocumentDTO> documents = new HashSet<DocumentDTO>();
//	private Set<AccountDTO> accounts = new HashSet<AccountDTO>();
	
	
	public StudentDTO() {
		super();
	}
	
	public StudentDTO(Long id, String firstName, String lastName, String email, String cardNumber, Long userId,
			String user) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.cardNumber = cardNumber;
		this.userId = userId;
		this.user = user;
//		this.enrollments = enrollments;
//		this.documents = documents;
//		this.accounts = accounts;
	}
	
	public StudentDTO(Student student) {
		this(student.getId(), student.getFirstName(), student.getLastName(), student.getEmail(), student.getCardNumber(), student.getUser().getId(), student.getUser().getUsername());
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCardNumber() {
		return cardNumber;
	}


	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}


	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


//	public Set<EnrollmentDTO> getEnrollments() {
//		return enrollments;
//	}
//
//
//	public void setEnrollments(Set<EnrollmentDTO> enrollments) {
//		this.enrollments = enrollments;
//	}
//
//
//	public Set<DocumentDTO> getDocuments() {
//		return documents;
//	}
//
//
//	public void setDocuments(Set<DocumentDTO> documents) {
//		this.documents = documents;
//	}
//
//
//	public Set<AccountDTO> getAccounts() {
//		return accounts;
//	}
//
//
//	public void setAccounts(Set<AccountDTO> accounts) {
//		this.accounts = accounts;
//	}

}
