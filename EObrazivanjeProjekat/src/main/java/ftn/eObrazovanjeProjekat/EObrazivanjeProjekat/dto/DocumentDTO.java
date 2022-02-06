package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Document;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.DocumentType;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Student;

public class DocumentDTO {
	
	private Long idDokument;
	private String title;
	private String url;
	private StudentDTO studentDTO;
	private DocumentTypeDTO dokumentTypeDTO;
	
	public DocumentDTO(Document document) {
		this(document.getIdDokument(), document.getTitle(), document.getUrl(), new StudentDTO(document.getStudent()), new DocumentTypeDTO(document.getDokumentType()));
	}
	
	public DocumentDTO(Long idDokument,String title,String url,StudentDTO studentDTO,DocumentTypeDTO dokumentTypeDTO) {
		super();
		this.idDokument = idDokument;
		this.title = title;
		this.url = url;
		this.studentDTO = studentDTO;
		this.dokumentTypeDTO = dokumentTypeDTO;
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

	public StudentDTO getStudentDTO() {
		return studentDTO;
	}

	public void setStudentDTO(StudentDTO studentDTO) {
		this.studentDTO = studentDTO;
	}

	public DocumentTypeDTO getDokumentTypeDTO() {
		return dokumentTypeDTO;
	}

	public void setDokumentTypeDTO(DocumentTypeDTO dokumentTypeDTO) {
		this.dokumentTypeDTO = dokumentTypeDTO;
	}

	
	
	
}
