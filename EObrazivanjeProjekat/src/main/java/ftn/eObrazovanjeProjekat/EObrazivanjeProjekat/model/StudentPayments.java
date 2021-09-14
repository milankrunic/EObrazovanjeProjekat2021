package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student_payments")
public class StudentPayments extends JpaEntity {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "amount", unique = false, nullable = false)
	private Integer amount;
	
	@Column(name = "date", unique = false, nullable = false)
	private Date date;
	
	@Column(name = "name", unique = false, nullable = false)
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "account", referencedColumnName = "idAccount", nullable = false)
	private Account account;
	
	public StudentPayments() {
		super();
	}

	public StudentPayments(Long id, Integer amount, Date date, String name, Account account) {
		super(id);
		this.amount = amount;
		this.date = date;
		this.name = name;
		this.account = account;
	}


	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}
