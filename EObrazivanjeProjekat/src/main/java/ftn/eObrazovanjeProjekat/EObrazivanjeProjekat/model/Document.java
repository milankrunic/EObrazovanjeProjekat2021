package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Document")
public class Document {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idDokument", nullable = false, unique = true)
	private Long idDokument;
	
	@Column(name = "title", unique = false, nullable = false)
	private String title;
	
	@Column(name = "url", unique = false, nullable = false)
	private String url;
	
	@ManyToOne
	@JoinColumn(name = "student", referencedColumnName = "idStudent", nullable = false)
	private Student student;
	
	@ManyToOne
	@JoinColumn(name = "document_type", referencedColumnName = "idDokumentType", nullable = false)
	private DocumentType dokumentType;
	
	public Document() {
		super();
	}

	public Document(Long idDokument, String title, String url, Student student, DocumentType dokumentType) {
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

