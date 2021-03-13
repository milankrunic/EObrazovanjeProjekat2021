package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Document type")
public class DocumentType {
	
	@Column(name = "name", unique = false, nullable = false)
	private String name;
	
	@Column(name = "code", unique = false, nullable = false)
	private String code;
	
	public DocumentType() {
		super();
	}
	
	public DocumentType(String name,String code) {
		super();
		this.name = name;
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
}
