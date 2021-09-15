package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto;

import java.util.HashSet;
import java.util.Set;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.ExamPart;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.ExamPartType;

public class ExamPartTypeDTO {
	

	private Long id;
	private String name;
	private String code;
	private Set<ExamPartDTO> examParts = new HashSet<ExamPartDTO>();
	
	public ExamPartTypeDTO() {
		super();
	}

	public ExamPartTypeDTO(Long id, String name, String code, Set<ExamPartDTO> examParts) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.examParts = examParts;
	}
	
//	public ExamPartTypeDTO(ExamPartType ept) {
//		this(ept.getId(),ept.getName(),ept.getCode(),ept.getExamPart());
//	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Set<ExamPartDTO> getExamParts() {
		return examParts;
	}

	public void setExamParts(Set<ExamPartDTO> examParts) {
		this.examParts = examParts;
	}
	
	
}
