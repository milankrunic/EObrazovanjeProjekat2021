package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.CourseSpecification;

public class CourseSpecificationDTO {
	
	private Long idCourseSpecification;
	private String title;
	private Integer ects;
	private String code;
	
	public CourseSpecificationDTO() {
		super();
	}

	public CourseSpecificationDTO(Long idCourseSpecification, String title, Integer ects, String code) {
		super();
		this.idCourseSpecification = idCourseSpecification;
		this.title = title;
		this.ects = ects;
		this.code = code;
	}

	public CourseSpecificationDTO(CourseSpecification cs) {
		this(cs.getIdCourseSpecification(), cs.getTitle(), cs.getEcts(), cs.getCode());
	}
	
	public Long getIdCourseSpecification() {
		return idCourseSpecification;
	}

	public void setIdCourseSpecification(Long idCourseSpecification) {
		this.idCourseSpecification = idCourseSpecification;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getEcts() {
		return ects;
	}

	public void setEcts(Integer ects) {
		this.ects = ects;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
