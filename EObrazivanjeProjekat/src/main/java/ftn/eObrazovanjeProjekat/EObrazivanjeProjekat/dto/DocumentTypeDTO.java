package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.DocumentType;

public class DocumentTypeDTO {
	
	private Long idDokumentType;
	private String name;
	private String code;
	
	public DocumentTypeDTO(Long idDokumentType,String name,String code) {
		super();
		this.idDokumentType = idDokumentType;
		this.name = name;
		this.code = code;
	}
	
	public DocumentTypeDTO() {
		super();
	}
	
	public DocumentTypeDTO(DocumentType document) {
		this(document.getIdDokumentType(),document.getName(),document.getCode());
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
