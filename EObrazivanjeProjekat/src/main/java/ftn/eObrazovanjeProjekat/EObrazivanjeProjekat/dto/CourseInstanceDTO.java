package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.CourseInstance;

public class CourseInstanceDTO {
	
	private Long idCourseInstance;
	private String startDate;
	private String endDate;
	private Long idCourseSpecification;
	private String nameCourseSpecification;
	
	public CourseInstanceDTO() {
		super();
	}

	public CourseInstanceDTO(Long idCourseInstance, String startDate, String endDate, Long idCourseSpecification,
			String nameCourseSpecification) {
		super();
		this.idCourseInstance = idCourseInstance;
		this.startDate = startDate;
		this.endDate = endDate;
		this.idCourseSpecification = idCourseSpecification;
		this.nameCourseSpecification = nameCourseSpecification;
	}
	
	public CourseInstanceDTO(CourseInstance ci) {
		this(ci.getIdCourseInstance(), ci.getStartDate(), ci.getEndDate(), ci.getCourseSpecification().getIdCourseSpecification(), ci.getCourseSpecification().getTitle());
	}

	public Long getIdCourseInstance() {
		return idCourseInstance;
	}

	public void setIdCourseInstance(Long idCourseInstance) {
		this.idCourseInstance = idCourseInstance;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Long getIdCourseSpecification() {
		return idCourseSpecification;
	}

	public void setIdCourseSpecification(Long idCourseSpecification) {
		this.idCourseSpecification = idCourseSpecification;
	}

	public String getNameCourseSpecification() {
		return nameCourseSpecification;
	}

	public void setNameCourseSpecification(String nameCourseSpecification) {
		this.nameCourseSpecification = nameCourseSpecification;
	}
}
