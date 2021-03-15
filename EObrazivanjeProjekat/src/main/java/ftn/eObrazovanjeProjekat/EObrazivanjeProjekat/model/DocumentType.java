package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="document_type")
public class DocumentType {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idDokumentType", nullable = false, unique = true)
	private Long idDokumentType;
	
	@Column(name = "name", unique = false, nullable = false)
	private String name;
	
	@Column(name = "code", unique = false, nullable = false)
	private String code;
	
	public DocumentType() {
		super();
	}
	
	public DocumentType(Long idDokumentType, String name,String code) {
		super();
		this.idDokumentType = idDokumentType;
		this.name = name;
		this.code = code;
	}

	public Long getIdDokumentType() {
		return idDokumentType;
	}

	public void setIdDokumentType(Long idDokumentType) {
		this.idDokumentType = idDokumentType;
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
