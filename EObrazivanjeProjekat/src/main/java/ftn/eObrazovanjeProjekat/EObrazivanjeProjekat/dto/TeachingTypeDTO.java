package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.TeachingType;

public class TeachingTypeDTO {
	
	private Long id;
	private String name;
	private String code;
	
	public TeachingTypeDTO() {
		super();
	}

	public TeachingTypeDTO(Long id, String name, String code) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
	}
	
	public TeachingTypeDTO(TeachingType tt) {
		this(tt.getId(), tt.getName(), tt.getCode());
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
