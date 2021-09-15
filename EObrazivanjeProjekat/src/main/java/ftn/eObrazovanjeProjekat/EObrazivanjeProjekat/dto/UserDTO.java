package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto;

import java.io.Serializable;


import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.User;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String user_name;
	private String password;
	

	public UserDTO() {
		super();
	}
	

	public UserDTO(Long id, String user_name, String password) {
		super();
		this.id = id;
		this.user_name = user_name;
		this.password = password;
	}

	public UserDTO(User u) {
		this(u.getId(), u.getUsername(), u.getPassword());
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
