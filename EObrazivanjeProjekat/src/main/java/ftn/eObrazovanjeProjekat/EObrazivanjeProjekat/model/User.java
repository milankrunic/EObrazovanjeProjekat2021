package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idUser", nullable = false, unique = true)
	private Long idUser;
	
	@Column(name = "user_name", nullable = false)
	private String user_name;
	
	@Column(name = "password", nullable = false)
	private String password;
	

	public User(Long idUser, String user_name, String password) {
		super();
		this.idUser = idUser;
		this.user_name = user_name;
		this.password = password;
	}
		
}
