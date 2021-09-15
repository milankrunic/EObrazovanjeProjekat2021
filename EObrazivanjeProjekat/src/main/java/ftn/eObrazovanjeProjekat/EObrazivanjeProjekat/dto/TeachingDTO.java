package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Teaching;

public class TeachingDTO {
	
	private Long id;
	private Long courseInstance;
	private Long teacher;
	private Long teachingType;
	private String nameTeacher;
	private String nameTeachingType;
	
	public TeachingDTO() {
		super();
	}

	public TeachingDTO(Long id, Long courseInstance, Long teacher, Long teachingType, String nameTeacher,
			String nameTeachingType) {
		super();
		this.id = id;
		this.courseInstance = courseInstance;
		this.teacher = teacher;
		this.teachingType = teachingType;
		this.nameTeacher = nameTeacher;
		this.nameTeachingType = nameTeachingType;
	}
	
	public TeachingDTO(Teaching te) {
		this(te.getId(), te.getCourseInstance().getId(), te.getTeacher().getId(), te.getTeachingType().getId(), te.getTeacher().getLastName(), te.getTeachingType().getName());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getNameTeacher() {
		return nameTeacher;
	}

	public void setNameTeacher(String nameTeacher) {
		this.nameTeacher = nameTeacher;
	}

	public String getNameTeachingType() {
		return nameTeachingType;
	}

	public void setNameTeachingType(String nameTeachingType) {
		this.nameTeachingType = nameTeachingType;
	}
}
