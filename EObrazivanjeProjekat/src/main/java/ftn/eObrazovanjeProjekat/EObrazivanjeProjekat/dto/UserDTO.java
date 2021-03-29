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


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public UserDTO(Long idUser, String user_name, String password) {
		super();
		this.idUser = idUser;
		this.user_name = user_name;
		this.password = password;
	}

	public UserDTO(User u) {
		this(u.getIdUser(), u.getUsername(), u.getPassword());
	}
}
