package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "User")
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private Long id;
	
	@Column(name = "username", nullable = true)
	private String username;
	
	@Column(name = "password", nullable = true)
	private String password;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "user")
	private List<UserRole> userRoles = new ArrayList<UserRole>();

	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "user")
	private List<Admin> administrators = new ArrayList<Admin>();
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "user")
	private List<Student> students = new ArrayList<Student>();
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "user")
	private List<Teacher> teachers = new ArrayList<Teacher>();
	
	
	public User() {
		super();
	
	}

	public User(Long id, String username, String password, List<UserRole> role,
			List<Admin> administrators, List<Student> students, List<Teacher> teachers) {
		super();
		this.id = id;

		this.username = username;
		this.password = password;
		this.userRoles = role;
		this.administrators = administrators;
		this.students = students;
		this.teachers = teachers;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public List<Admin> getAdministrators() {
		return administrators;
	}

	public void setAdministrators(List<Admin> administrators) {
		this.administrators = administrators;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	
	
	
}
