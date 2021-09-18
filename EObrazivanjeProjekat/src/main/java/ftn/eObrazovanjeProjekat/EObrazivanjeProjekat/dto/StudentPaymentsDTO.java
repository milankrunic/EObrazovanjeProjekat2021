package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto;

import java.util.Date;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Account;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.StudentPayments;

public class StudentPaymentsDTO {
	
	private Long id;
	private Integer amount;
	private Date date;
	private String name;
	private AccountDTO accountDTO;
	
	public StudentPaymentsDTO(StudentPayments payments) {
		super();
	}
	
	public StudentPaymentsDTO(Long id,Integer amount,Date date,String name,AccountDTO accountDTO) {
		super();
		this.id = id;
		this.amount = amount;
		this.date = date;
		this.name = name;
		this.accountDTO = accountDTO;
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

	public AccountDTO getAccountDTO() {
		return accountDTO;
	}

	public void setAccountDTO(AccountDTO accountDTO) {
		this.accountDTO = accountDTO;
	}


}