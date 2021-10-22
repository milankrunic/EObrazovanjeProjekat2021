package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto;

import java.util.HashSet;
import java.util.Set;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.ExamPartStatus;

public class ExamPartStatusDTO {
	
	
	private Long id;
	private String name;
	private String code;
	
	public ExamPartStatusDTO(Long id, String name, String code) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
	}

	public ExamPartStatusDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ExamPartStatusDTO(ExamPartStatus e) {
		this(e.getIdExamPartStatus(),e.getName(),e.getCode());
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
	};
	
}
