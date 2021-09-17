package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Teaching;

public class TeachingDTO {
	
	private Long idTeaching;
	private Long courseInstance;
	private Long teacher;
	private Long teachingType;
	private String nameTeachingType;
	
	public TeachingDTO() {
		super();
	}

	public TeachingDTO(Long idTeaching, Long courseInstance, Long teacher, Long teachingType,
			String nameTeachingType) {
		super();
		this.idTeaching = idTeaching;
		this.courseInstance = courseInstance;
		this.teacher = teacher;
		this.teachingType = teachingType;
		this.nameTeachingType = nameTeachingType;
	}
	
	public TeachingDTO(Teaching te) {
		this(te.getIdTeaching(), te.getCourseInstance().getIdCourseInstance(), te.getTeacher().getIdTeacher(), te.getTeachingType().getIdTeachingType(), te.getTeachingType().getName());
	}

	public Long getIdTeaching() {
		return idTeaching;
	}

	public void setIdTeaching(Long idTeaching) {
		this.idTeaching = idTeaching;
	}

	public Long getCourseInstance() {
		return courseInstance;
	}

	public void setCourseInstance(Long courseInstance) {
		this.courseInstance = courseInstance;
	}

	public Long getTeacher() {
		return teacher;
	}

	public void setTeacher(Long teacher) {
		this.teacher = teacher;
	}

	public Long getTeachingType() {
		return teachingType;
	}

	public void setTeachingType(Long teachingType) {
		this.teachingType = teachingType;
	}


	public String getNameTeachingType() {
		return nameTeachingType;
	}

	public void setNameTeachingType(String nameTeachingType) {
		this.nameTeachingType = nameTeachingType;
	}
}
