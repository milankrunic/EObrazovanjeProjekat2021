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
@Table(name = "Enrollment")
public class Enrollment {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idEnrollment", nullable = false, unique = true)
	private Long idEnrollment;
	
	@ManyToOne
	@JoinColumn(name = "course_instance", referencedColumnName = "idCourseInstance", nullable = false)
	private CourseInstance courseInstance;
	
	@ManyToOne
	@JoinColumn(name = "student", referencedColumnName = "idStudent", nullable = false)
	private Student student;
	
	@OneToMany(cascade = {ALL}, fetch=LAZY, mappedBy="enrollment")
	private List<Exam> exam = new ArrayList<Exam>();
	
	public Enrollment() {
		super();
	}

	public Enrollment(Long idEnrollment, CourseInstance courseInstance, Student student, List<Exam> exam) {
		super();
		this.idEnrollment = idEnrollment;
		this.courseInstance = courseInstance;
		this.student = student;
		this.exam = exam;
	}

	public Long getIdEnrollment() {
		return idEnrollment;
	}

	public void setIdEnrollment(Long idEnrollment) {
		this.idEnrollment = idEnrollment;
	}

	public CourseInstance getCourseInstance() {
		return courseInstance;
	}

	public void setCourseInstance(CourseInstance courseInstance) {
		this.courseInstance = courseInstance;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<Exam> getExam() {
		return exam;
	}

	public void setExam(List<Exam> exam) {
		this.exam = exam;
	}
}
