package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Admin")
public class Admin {
	
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "idAdmin", nullable = false, unique = true)
	//private Long idAdmin;
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	public Admin() {
		super();
	}

	public Admin(String firstName, String lastName, String email) {
		super();
		//this.idAdmin = idAdmin;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

//	public Long getIdAdmin() {
//		return idAdmin;
//	}
//
//	public void setIdAdmin(Long idAdmin) {
//		this.idAdmin = idAdmin;
//	}

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
	
	
}
