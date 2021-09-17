package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto.ExamPartDTO;

@Entity
@Table(name = "exam")
public class Exam {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idExam", nullable = false, unique = true)
	private Long idExam;
	
	@Column(name = "points", nullable = false)
	private Integer points;
	
	@Column(name = "grade", nullable = false)
	private Integer grade;
	
	@ManyToOne
	@JoinColumn(name = "enrollment", referencedColumnName = "idEnrollment", nullable = false)
	private Enrollment enrollment;
	
	@OneToMany(cascade = {ALL}, fetch=LAZY, mappedBy="exam")
	private List<ExamPart> examPart = new ArrayList<ExamPart>();
	
	public Exam() {
		super();
	}

	public Exam(Long idExam, Integer points, Integer grade, Enrollment enrollment, List<ExamPart> examPart) {
		super();
		this.idExam = idExam;
		this.points = points;
		this.grade = grade;
		this.enrollment = enrollment;
		this.examPart = examPart;
	}

	public Long getIdExam() {
		return idExam;
	}

	public void setIdExam(Long idExam) {
		this.idExam = idExam;
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

	public Enrollment getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(Enrollment enrollment) {
		this.enrollment = enrollment;
	}

	public List<ExamPart> getExamPart() {
		return examPart;
	}

	public void setExamPart(List<ExamPart> examPart) {
		this.examPart = examPart;
	}

	
}
