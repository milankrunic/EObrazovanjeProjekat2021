package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.UserRole;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.User;


public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idUser;
	private String firstName;
	private String lastName;
	private String email;
	private String userName;
	private String password;
	private List<RoleDTO> roles = new ArrayList<RoleDTO>();
	
	
	public UserDTO() {
		super();
	}

	public UserDTO(User user) {
		this(user.getId(),user.getFirstName(),user.getLastName(), user.getEmail(), user.getUsername(),user.getPassword(), user.getUserRoles());
	}
	
	public UserDTO(Long idUser, String firstName, String lastName, String email, String userName, String password, List<UserRole> roles) {
		super();
		this.idUser = idUser;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userName = userName;
		this.password = password;
		for (UserRole userRole : roles) {
			this.roles.add(new RoleDTO(userRole.getRole()));
		}
	}


	public Long getIdUser() {
		return idUser;
	}


	public void setIdUser(Long idUser) {
		this.idUser = idUser;
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


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String roleToString() {
		String roleString = "";
		for (RoleDTO role : this.roles) {
			roleString += role.getCode()+" ";
		}
		return roleString;
	}
	
	
	
}
