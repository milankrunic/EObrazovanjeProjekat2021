package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto;



import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Enrollment;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Exam;

public class ExamDTO {
	
	private Long id;
	private Integer points;
	private Integer grade;
	private EnrollmentDTO enrollmentDTO;
	
	
	public ExamDTO(Long id, Integer points, Integer grade, EnrollmentDTO enrollmentDTO) {
		super();
		this.id = id;
		this.points = points;
		this.grade = grade;
		this.enrollmentDTO = enrollmentDTO;
	}


	public ExamDTO(Exam exam) {
		this(exam.getIdExam(), exam.getPoints(), exam.getGrade(), new EnrollmentDTO(exam.getEnrollment()));
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}


	public EnrollmentDTO getEnrollmentDTO() {
		return enrollmentDTO;
	}


	public void setEnrollmentDTO(EnrollmentDTO enrollmentDTO) {
		this.enrollmentDTO = enrollmentDTO;
	}

	
	
	
}
