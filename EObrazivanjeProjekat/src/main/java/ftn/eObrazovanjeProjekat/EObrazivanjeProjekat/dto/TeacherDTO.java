package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Teacher;

public class TeacherDTO {
	
	private Long id;
	private Long idUser;
	private String user;
	private UserDTO userDTO;
	
	public TeacherDTO() {
		super();
	}

	public TeacherDTO(Long id, Long idUser, String user, UserDTO userDTO) {
		super();
		this.id = id;

		this.idUser = idUser;
		this.user = user;
		this.userDTO = userDTO;
	}
	
	public TeacherDTO(Teacher teacher) {
		this(teacher.getIdTeacher(), teacher.getUser().getId(), teacher.getUser().getUsername(), new UserDTO(teacher.getUser()));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}

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
	
	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

}
