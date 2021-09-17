package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.TeachingType;

public class TeachingTypeDTO {
	
	private Long idTeachingType;
	private String name;
	private String code;
	
	public TeachingTypeDTO() {
		super();
	}

	public TeachingTypeDTO(Long idTeachingType, String name, String code) {
		super();
		this.idTeachingType = idTeachingType;
		this.name = name;
		this.code = code;
	}
	
	public TeachingTypeDTO(TeachingType tt) {
		this(tt.getIdTeachingType(), tt.getName(), tt.getCode());
	}

	public Long getIdTeachingType() {
		return idTeachingType;
	}

	public void setIdTeachingType(Long idTeachingType) {
		this.idTeachingType = idTeachingType;
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
