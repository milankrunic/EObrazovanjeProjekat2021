package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto;

import java.util.Date;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Account;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.StudentPayments;

public class StudentPaymentsDTO {
	
	private Long id;
	private Integer amount;
	private Date date;
	private String name;
	private Account account;
	
	public StudentPaymentsDTO() {
		super();
	}
	
	public StudentPaymentsDTO(Long id,Integer amount,Date date,String name,Account account) {
		super();
		this.id = id;
		this.amount = amount;
		this.date = date;
		this.name = name;
		this.account = account;
	}
	
	
	public StudentPaymentsDTO(StudentPayments sp) {
		this(sp.getId(),sp.getAmount(),sp.getDate(),sp.getName(),sp.getAccount());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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