package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Admin;

public class AdminDTO {
	
	private Long idAdmin;
	private String firstName;
	private String lastName;
	private String email;
	private Long idUser;
	private String user;
	
	public AdminDTO() {
		super();
	}
	
	public AdminDTO(Long idAdmin, String firstName, String lastName, String email, Long idUser, String user) {
		super();
		this.idAdmin = idAdmin;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.idUser = idUser;
		this.user = user;
	}

	public AdminDTO(Admin admin) {
		this(admin.getIdAdmin(), admin.getFirstName(), admin.getLastName(), admin.getEmail(), admin.getUser().getIdUser(), admin.getUser().getUsername());
	}

	public Long getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(Long idAdmin) {
		this.idAdmin = idAdmin;
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
