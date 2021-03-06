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
@Table(name = "exam_part_type")
public class ExamPartType {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idExamPartType", nullable = false, unique = true)
	private Long idExamPartType;
	
	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "code", nullable = false)
	private String code;
	
	@OneToMany(cascade = {ALL}, fetch=LAZY, mappedBy="examPartType")
	private List<ExamPart> examPart = new ArrayList<ExamPart>();
	
	public ExamPartType() {
		super();
	}

	public ExamPartType(Long idExamPartType, String name, String code, List<ExamPart> examPart) {
		super();
		this.idExamPartType = idExamPartType;
		this.name = name;
		this.code = code;
		this.examPart = examPart;
	}

	public Long getIdExamPartType() {
		return idExamPartType;
	}

	public void setIdExamPartType(Long idExamPartType) {
		this.idExamPartType = idExamPartType;
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

	public List<ExamPart> getExamPart() {
		return examPart;
	}

	public void setExamPart(List<ExamPart> examPart) {
		this.examPart = examPart;
	}
}
