package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Admin;

public class AdminDTO {
	
	private Long id;
	private String email;
	private Long idUser;
	private String user;
	
	public AdminDTO() {
		super();
	}
	
	public AdminDTO(Long id, String email, Long idUser, String user) {
		super();
		this.id = id;
		this.email = email;
		this.idUser = idUser;
		this.user = user;
	}

	public AdminDTO(Admin admin) {
		this(admin.getIdAdmin(), admin.getEmail(), admin.getUser().getId(), admin.getUser().getUsername());
	}

	public Long getIdAdmin() {
		return id;
	}

	public void setIdAdmin(Long id) {
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
