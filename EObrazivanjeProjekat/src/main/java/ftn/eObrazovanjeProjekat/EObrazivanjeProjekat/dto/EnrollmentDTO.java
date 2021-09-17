package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto;

import java.util.HashSet;
import java.util.Set;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.CourseInstance;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Enrollment;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Student;

public class EnrollmentDTO {
	
	private Long id;
	private CourseInstance courseInstance;
	private Student student;
	private Set<ExamDTO> exams = new HashSet<ExamDTO>();
	
	public EnrollmentDTO(Long id, CourseInstance courseInstance, Student student, Set<ExamDTO> exams) {
		super();
		this.id = id;
		this.courseInstance = courseInstance;
		this.student = student;
		this.exams = exams;
	}

	public EnrollmentDTO(Enrollment enrollment) {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Set<ExamDTO> getExams() {
		return exams;
	}

	public void setExams(Set<ExamDTO> exams) {
		this.exams = exams;
	}
	
	
	
	
}
