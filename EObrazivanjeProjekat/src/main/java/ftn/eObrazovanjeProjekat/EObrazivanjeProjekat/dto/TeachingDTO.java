package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Teaching;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto.*;
public class TeachingDTO {
	
	private Long idTeaching;
	private CourseInstanceDTO courseInstance;
	private TeacherDTO teacher;
	private TeachingTypeDTO teachingType;
	
	
	public TeachingDTO() {
		super();
	}

	public TeachingDTO(Long idTeaching, CourseInstanceDTO courseInstance, TeacherDTO teacher, TeachingTypeDTO teachingType) {
		super();
		this.idTeaching = idTeaching;
		this.courseInstance = courseInstance;
		this.teacher = teacher;
		this.teachingType = teachingType;
		
	}
	
	public TeachingDTO(Teaching te) {
		this(te.getIdTeaching(), new CourseInstanceDTO(te.getCourseInstance()), new TeacherDTO(te.getTeacher()), new TeachingTypeDTO(te.getTeachingType()));
	}

	public Long getIdTeaching() {
		return idTeaching;
	}

	public void setIdTeaching(Long idTeaching) {
		this.idTeaching = idTeaching;
	}

	public CourseInstanceDTO getCourseInstance() {
		return courseInstance;
	}

	public void setCourseInstance(CourseInstanceDTO courseInstance) {
		this.courseInstance = courseInstance;
	}

	public TeacherDTO getTeacher() {
		return teacher;
	}

	public void setTeacher(TeacherDTO teacher) {
		this.teacher = teacher;
	}

	public TeachingTypeDTO getTeachingType() {
		return teachingType;
	}

	public void setTeachingType(TeachingTypeDTO teachingType) {
		this.teachingType = teachingType;
	}


	
	
	
}
