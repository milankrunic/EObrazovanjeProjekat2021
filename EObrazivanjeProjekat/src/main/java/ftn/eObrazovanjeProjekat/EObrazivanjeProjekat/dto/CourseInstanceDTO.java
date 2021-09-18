package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.CourseInstance;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto.CourseSpecificationDTO;

public class CourseInstanceDTO {
	
	private Long idCourseInstance;
	private String startDate;
	private String endDate;
	private CourseSpecificationDTO courseSpecificationDTO;
	
	public CourseInstanceDTO() {
		super();
	}

	public CourseInstanceDTO(Long idCourseInstance, String startDate, String endDate, CourseSpecificationDTO courseSpecificationDTO 
			 ) {
		super();
		this.idCourseInstance = idCourseInstance;
		this.startDate = startDate;
		this.endDate = endDate;
		this.courseSpecificationDTO = courseSpecificationDTO;
		
	}
	
	public CourseInstanceDTO(CourseInstance ci) {
		this(ci.getIdCourseInstance(), ci.getStartDate(), ci.getEndDate(),  new CourseSpecificationDTO(ci.getCourseSpecification()));
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

	public CourseSpecificationDTO getCourseSpecificationDTO() {
		return courseSpecificationDTO;
	}

	public void setCourseSpecificationDTO(CourseSpecificationDTO courseSpecificationDTO) {
		this.courseSpecificationDTO = courseSpecificationDTO;
	}

	
}
