package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Document;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.DocumentType;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Student;

public class DocumentDTO {
	
	private Long id;
	private String title;
	private String url;
	private Student student;
	private DocumentType dokumentType;
	
	public DocumentDTO() {
		super();
	}
	
	public DocumentDTO(Long id,String title,String url,Student student,DocumentType dokumentType) {
		super();
		this.id = id;
		this.title = title;
		this.url = url;
		this.student = student;
		this.dokumentType = dokumentType;
	}
	
	public DocumentDTO(Document doc) {
		this(doc.getId(),doc.getTitle(),doc.getUrl(),doc.getStudent(),doc.getDokumentType());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
