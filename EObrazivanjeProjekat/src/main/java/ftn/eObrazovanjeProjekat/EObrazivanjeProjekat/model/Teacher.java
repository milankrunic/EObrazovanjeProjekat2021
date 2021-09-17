package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "teacher")
public class Teacher {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_teacher", nullable = false, unique = true)
	private Long idTeacher;

	
	@Column(name = "email", nullable = false)
	private String email;
	
	@OneToMany(cascade = {ALL}, fetch=LAZY, mappedBy="teacher")
	private List<Teaching> teaching = new ArrayList<Teaching>();
	
//	@ManyToOne
//	@JoinColumn(name = "id_user", referencedColumnName = "id_user", nullable = false)
//	private User user;
	
	@OneToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_user", referencedColumnName = "id")
	private User user;
	
	public Teacher() {
		super();
	}

	public Teacher(Long idTeacher, String email, List<Teaching> teaching,
			User user) {
		super();
		this.idTeacher = idTeacher;
		
		this.email = email;
		this.teaching = teaching;
		this.user = user;
	}

	public Long getIdTeacher() {
		return idTeacher;
	}

	public void setIdTeacher(Long idTeacher) {
		this.idTeacher = idTeacher;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Teaching> getTeaching() {
		return teaching;
	}

	public void setTeaching(List<Teaching> teaching) {
		this.teaching = teaching;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
