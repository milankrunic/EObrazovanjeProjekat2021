package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Teacher;

public class TeacherDTO {
	
	private Long id;
	private String email;
	private Long idUser;
	private String user;
	
	public TeacherDTO() {
		super();
	}

	public TeacherDTO(Long id, String email, Long idUser, String user) {
		super();
		this.id = id;

		this.email = email;
		this.idUser = idUser;
		this.user = user;
	}
	
	public TeacherDTO(Teacher teacher) {
		this(teacher.getIdTeacher(), teacher.getEmail(), teacher.getUser().getId(), teacher.getUser().getUsername());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
