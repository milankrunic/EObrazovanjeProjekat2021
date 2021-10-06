package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Student")
public class Student {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idStudent", nullable = false, unique = true)
	private Long idStudent;

	
	@Column(name = "card_number", nullable = false)
	private String cardNumber;
	
//	@Column(name = "email", nullable = false)
//	private String email;
	
//	@ManyToOne
//	@JoinColumn(name = "id_user", referencedColumnName = "id_user", nullable = false)
//	private User user;
	
	@OneToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_user", referencedColumnName = "id")
	private User user;
	
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Enrollment> enrollments = new HashSet<Enrollment>();
	
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Document> document = new HashSet<Document>();
	
	
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Account> account = new HashSet<Account>();
	
	public Student() {
		super();
	}

	public Student(Long idStudent, String cardNumber, User user,
			Set<Enrollment> enrollments, Set<Document> document, Set<Account> account) {
		super();
		this.idStudent = idStudent;

		this.cardNumber = cardNumber;

		this.user = user;
		this.enrollments = enrollments;
		this.document = document;
		this.account = account;
	}

	public Long getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(Long idStudent) {
		this.idStudent = idStudent;
	}


	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Enrollment> getEnrollments() {
		return enrollments;
	}

	public void setEnrollments(Set<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}

	public Set<Document> getDocument() {
		return document;
	}

	public void setDocument(Set<Document> document) {
		this.document = document;
	}

	public Set<Account> getAccount() {
		return account;
	}

	public void setAccount(Set<Account> account) {
		this.account = account;
	}
}
