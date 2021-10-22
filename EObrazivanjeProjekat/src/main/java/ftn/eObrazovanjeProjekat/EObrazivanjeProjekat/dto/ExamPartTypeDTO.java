package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto;

import java.util.HashSet;
import java.util.Set;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.ExamPart;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.ExamPartType;

public class ExamPartTypeDTO {
	

	private Long id;
	private String name;
	private String code;
	
	public ExamPartTypeDTO() {
		super();
	}

	public ExamPartTypeDTO(Long id, String name, String code) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
	}
	
	public ExamPartTypeDTO(ExamPartType e) {
		this(e.getIdExamPartType(),e.getName(),e.getCode());
	}

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
	
}
