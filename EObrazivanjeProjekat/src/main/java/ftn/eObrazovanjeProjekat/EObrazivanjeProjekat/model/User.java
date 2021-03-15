package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idUser", nullable = false, unique = true)
	private Long idUser;
	
	@Column(name = "user_name", nullable = false)
	private String user_name;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@OneToMany(cascade = {ALL}, fetch=LAZY, mappedBy="user")
	private List<Student> student = new ArrayList<Student>();
	
	@OneToMany(cascade = {ALL}, fetch=LAZY, mappedBy="user")
	private List<Teacher> teacher = new ArrayList<Teacher>();
	
	@OneToMany(cascade = {ALL}, fetch=LAZY, mappedBy="user")
	private List<Admin> admin = new ArrayList<Admin>();
	
	public User() {
		super();
	}

	public User(Long idUser, String user_name, String password, List<Student> student, List<Teacher> teacher,
			List<Admin> admin) {
		super();
		this.idUser = idUser;
		this.user_name = user_name;
		this.password = password;
		this.student = student;
		this.teacher = teacher;
		this.admin = admin;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

	public List<Teacher> getTeacher() {
		return teacher;
	}

	public void setTeacher(List<Teacher> teacher) {
		this.teacher = teacher;
	}

	public List<Admin> getAdmin() {
		return admin;
	}

	public void setAdmin(List<Admin> admin) {
		this.admin = admin;
	}
}
