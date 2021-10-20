package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Enrollment;

public class EnrollmentDTO {
	
	private Long idEnrollment;
	
	private StudentDTO studentDTO;
	
	private CourseInstanceDTO courseInstanceDTO;

	public EnrollmentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public EnrollmentDTO(Enrollment e) {
		this(e.getIdEnrollment(), new StudentDTO(e.getStudent()), new CourseInstanceDTO(e.getCourseInstance()));
	}

	public EnrollmentDTO(Long idEnrollment, StudentDTO studentDTO, CourseInstanceDTO courseInstanceDTO) {
		super();
		this.idEnrollment = idEnrollment;
		this.studentDTO = studentDTO;
		this.courseInstanceDTO = courseInstanceDTO;
	}

	public Long getIdEnrollment() {
		return idEnrollment;
	}

	public void setIdEnrollment(Long idEnrollment) {
		this.idEnrollment = idEnrollment;
	}

	public StudentDTO getStudentDTO() {
		return studentDTO;
	}

	public void setStudentDTO(StudentDTO studentDTO) {
		this.studentDTO = studentDTO;
	}

	public CourseInstanceDTO getCourseInstanceDTO() {
		return courseInstanceDTO;
	}

	public void setCourseInstanceDTO(CourseInstanceDTO courseInstanceDTO) {
		this.courseInstanceDTO = courseInstanceDTO;
	}
}

