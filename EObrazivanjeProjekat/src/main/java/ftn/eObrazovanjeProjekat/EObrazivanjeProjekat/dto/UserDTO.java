package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.User;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idUser;
	private String user_name;
	private String password;
	private Set<TeacherDTO> teachers = new HashSet<TeacherDTO>();
	private Set<StudentDTO> students = new HashSet<StudentDTO>();
	private Set<AdminDTO> admins = new HashSet<AdminDTO>();
	
	

	public UserDTO() {
		super();
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

	public Set<TeacherDTO> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<TeacherDTO> teachers) {
		this.teachers = teachers;
	}

	public Set<StudentDTO> getStudents() {
		return students;
	}

	public void setStudents(Set<StudentDTO> students) {
		this.students = students;
	}

	public Set<AdminDTO> getAdmins() {
		return admins;
	}

	public void setAdmins(Set<AdminDTO> admins) {
		this.admins = admins;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public UserDTO(String user_name, String password) {
		super();
		this.user_name = user_name;
		this.password = password;
	}

	public UserDTO(User u) {
		// TODO Auto-generated constructor stub
	}
}
