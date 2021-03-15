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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CourseInstance")
public class CourseInstance {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCourseInstance", nullable = false, unique = true)
	private Long idCourseInstance;
	
	@Column(name = "start_date", nullable = false)
	private String startDate;
	
	@Column(name = "end_date", nullable = false)
	private String endDate;
	
	@ManyToOne
	@JoinColumn(name = "courseSpecification", referencedColumnName = "id", nullable = false)
	private CourseSpecification courseSpecification;
	
	@OneToMany(cascade = {ALL}, fetch=LAZY, mappedBy="courseInstance")
	private List<Teaching> teaching = new ArrayList<Teaching>();
	
	@OneToMany(cascade = {ALL}, fetch=LAZY, mappedBy="courseInstance")
	private List<Enrollment> enrollment = new ArrayList<Enrollment>();
	
	public CourseInstance() {
		super();
	}

	public CourseInstance(Long idCourseInstance, String startDate, String endDate, CourseSpecification courseSpecification,
			List<Teaching> teaching, List<Enrollment> enrollment) {
		super();
		this.idCourseInstance = idCourseInstance;
		this.startDate = startDate;
		this.endDate = endDate;
		this.courseSpecification = courseSpecification;
		this.teaching = teaching;
		this.enrollment = enrollment;
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

	public CourseSpecification getCourseSpecification() {
		return courseSpecification;
	}

	public void setCourseSpecification(CourseSpecification courseSpecification) {
		this.courseSpecification = courseSpecification;
	}

	public List<Teaching> getTeaching() {
		return teaching;
	}

	public void setTeaching(List<Teaching> teaching) {
		this.teaching = teaching;
	}

	public List<Enrollment> getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(List<Enrollment> enrollment) {
		this.enrollment = enrollment;
	}
}
