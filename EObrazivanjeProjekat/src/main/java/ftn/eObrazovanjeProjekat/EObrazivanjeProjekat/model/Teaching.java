package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Teaching")
public class Teaching {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idTeaching", nullable = false, unique = true)
	private Long idTeaching;

	@ManyToOne
	@JoinColumn(name = "course_instance", referencedColumnName = "idCourseInstance", nullable = false)
	private CourseInstance courseInstance;
	
	@ManyToOne
	@JoinColumn(name = "teacher", referencedColumnName = "id_teacher", nullable = false)
	private Teacher teacher;
	
	@ManyToOne
	@JoinColumn(name = "teaching_type", referencedColumnName = "idTeachingType", nullable = false)
	private TeachingType teachingType;
	
	public Teaching() {
		super();
	}

	public Teaching(Long idTeaching, CourseInstance courseInstance, Teacher teacher, TeachingType teachingType) {
		super();
		this.idTeaching = idTeaching;
		this.courseInstance = courseInstance;
		this.teacher = teacher;
		this.teachingType = teachingType;
	}

	public Long getIdTeaching() {
		return idTeaching;
	}

	public void setIdTeaching(Long idTeaching) {
		this.idTeaching = idTeaching;
	}

	public CourseInstance getCourseInstance() {
		return courseInstance;
	}

	public void setCourseInstance(CourseInstance courseInstance) {
		this.courseInstance = courseInstance;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public TeachingType getTeachingType() {
		return teachingType;
	}

	public void setTeachingType(TeachingType teachingType) {
		this.teachingType = teachingType;
	}
}
