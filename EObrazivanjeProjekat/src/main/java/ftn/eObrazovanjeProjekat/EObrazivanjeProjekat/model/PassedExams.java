package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PassedExams")
public class PassedExams {
	
	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPassedExams", nullable = false, unique = true)
	private Long idPassedExams;
	
//	videti ovo
	@OneToMany(cascade = {ALL}, fetch=LAZY, mappedBy="passedExams")
	private List<CourseInstance> courseInstance = new ArrayList<CourseInstance>();

	@OneToMany(cascade = {ALL}, fetch=LAZY, mappedBy="courseInstance")
	private List<Student> student = new ArrayList<Student>();
	
	@Column(name = "grade", unique = false, nullable = false)
	private Integer grade;
	
	@Column(name = "points", unique = false, nullable = false)
	private Integer points;
	
	@Column(name="passed", unique=false, nullable=false)
	private Boolean passed;
	
	@Column(name = "cond", unique = false, nullable = false)
	private CourseInstance course_Instance;
	
	@Column(name="type", unique=false, nullable=true, columnDefinition = "mediumtext")
	private String type;
	
	public PassedExams() {
		super();
	}
	
	
	public PassedExams(Long idPassedExams, List<CourseInstance> courseInstance, List<Student> student, Integer grade,
			Integer points, Boolean passed, CourseInstance course_Instance, String type) {
		super();
		this.idPassedExams = idPassedExams;
		this.courseInstance = courseInstance;
		this.student = student;
		this.grade = grade;
		this.points = points;
		this.passed = passed;
		this.course_Instance = course_Instance;
		this.type = type;
	}


	public Long getIdPassedExams() {
		return idPassedExams;
	}


	public void setIdPassedExams(Long idPassedExams) {
		this.idPassedExams = idPassedExams;
	}


	public List<CourseInstance> getCourseInstance() {
		return courseInstance;
	}


	public void setCourseInstance(List<CourseInstance> courseInstance) {
		this.courseInstance = courseInstance;
	}


	public List<Student> getStudent() {
		return student;
	}


	public void setStudent(List<Student> student) {
		this.student = student;
	}


	public Integer getGrade() {
		return grade;
	}


	public void setGrade(Integer grade) {
		this.grade = grade;
	}


	public Integer getPoints() {
		return points;
	}


	public void setPoints(Integer points) {
		this.points = points;
	}


	public Boolean getPassed() {
		return passed;
	}


	public void setPassed(Boolean passed) {
		this.passed = passed;
	}


	public CourseInstance getCourse_Instance() {
		return course_Instance;
	}


	public void setCourse_Instance(CourseInstance course_Instance) {
		this.course_Instance = course_Instance;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}
}
	