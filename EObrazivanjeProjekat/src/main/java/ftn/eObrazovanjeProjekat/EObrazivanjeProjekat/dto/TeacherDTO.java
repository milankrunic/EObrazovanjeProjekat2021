package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Teacher;

public class TeacherDTO {
	
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private Long idUser;
	private String user;
	
	public TeacherDTO() {
		super();
	}

	public TeacherDTO(Long id, String firstName, String lastName, String email, Long idUser, String user) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.idUser = idUser;
		this.user = user;
	}
	
	public TeacherDTO(Teacher teacher) {
		this(teacher.getId(), teacher.getFirstName(), teacher.getLastName(), teacher.getEmail(), teacher.getUser().getId(), teacher.getUser().getUsername());
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

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}
