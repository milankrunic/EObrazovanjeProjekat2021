package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Admin;

public class AdminDTO {
	
	private Long id;
	private Long idUser;
	private String user;
	private UserDTO userDTO;
	
	public AdminDTO() {
		super();
	}
	
	public AdminDTO(Long id, Long idUser, String user, UserDTO userDTO) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.user = user;
		this.userDTO = userDTO;
	}

	public AdminDTO(Admin admin) {
		this(admin.getIdAdmin(), admin.getUser().getId(), admin.getUser().getUsername(), new UserDTO(admin.getUser()));
	}

	public Long getIdAdmin() {
		return id;
	}

	public void setIdAdmin(Long id) {
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
