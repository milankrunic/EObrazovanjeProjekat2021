package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	@OneToMany(cascade = {ALL}, fetch=LAZY, mappedBy="dokumentType")
	private List<Document> document = new ArrayList<Document>();
	
	public DocumentType() {
		super();
	}

	public DocumentType(Long idDokumentType, String name, String code, List<Document> document) {
		super();
		this.idDokumentType = idDokumentType;
		this.name = name;
		this.code = code;
		this.document = document;
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

	public List<Document> getDocument() {
		return document;
	}

	public void setDocument(List<Document> document) {
		this.document = document;
	}
}
