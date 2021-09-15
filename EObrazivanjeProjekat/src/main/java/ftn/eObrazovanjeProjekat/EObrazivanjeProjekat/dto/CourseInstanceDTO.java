package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.CourseInstance;

public class CourseInstanceDTO {
	
	private Long id;
	private String startDate;
	private String endDate;
	private Long idCourseSpecification;
	private String nameCourseSpecification;
	
	public CourseInstanceDTO() {
		super();
	}

	public CourseInstanceDTO(Long id, String startDate, String endDate, Long idCourseSpecification,
			String nameCourseSpecification) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.idCourseSpecification = idCourseSpecification;
		this.nameCourseSpecification = nameCourseSpecification;
	}
	
	public CourseInstanceDTO(CourseInstance ci) {
		this(ci.getId(), ci.getStartDate(), ci.getEndDate(), ci.getCourseSpecification().getId(), ci.getCourseSpecification().getTitle());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
