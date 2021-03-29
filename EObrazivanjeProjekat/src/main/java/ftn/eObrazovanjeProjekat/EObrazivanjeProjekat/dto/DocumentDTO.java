package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.DocumentType;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Student;

public class DocumentDTO {
	
	private Long idDokument;
	private String title;
	private String url;
	private Student student;
	private DocumentType dokumentType;
	
	public DocumentDTO() {
		super();
	}
	
	public DocumentDTO(Long idDokument,String title,String url,Student student,DocumentType dokumentType) {
		super();
		this.idDokument = idDokument;
		this.title = title;
		this.url = url;
		this.student = student;
		this.dokumentType = dokumentType;
	}

	public Long getIdDokument() {
		return idDokument;
	}

	public void setIdDokument(Long idDokument) {
		this.idDokument = idDokument;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public DocumentType getDokumentType() {
		return dokumentType;
	}

	public void setDokumentType(DocumentType dokumentType) {
		this.dokumentType = dokumentType;
	}
	
	
}
