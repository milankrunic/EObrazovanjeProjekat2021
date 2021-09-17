package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Admin")
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idAdmin", nullable = false, unique = true)
	private Long idAdmin;
	
	
	@Column(name = "email", nullable = false)
	private String email;
	
//	@ManyToOne
//	@JoinColumn(name = "user", referencedColumnName = "id_user", nullable = false)
//	private User user;
	
	@OneToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_user", referencedColumnName = "id")
	private User user;
	
	public Admin() {
		super();
	}

	public Admin(Long idAdmin, String email, User user) {
		super();
		this.idAdmin = idAdmin;

		this.email = email;
		this.user = user;
	}

	public Long getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(Long idAdmin) {
		this.idAdmin = idAdmin;
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
