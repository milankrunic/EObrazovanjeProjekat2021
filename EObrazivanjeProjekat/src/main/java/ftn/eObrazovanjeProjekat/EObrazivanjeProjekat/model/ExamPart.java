package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "exam_part")
public class ExamPart {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idExamPart", nullable = false, unique = true)
	private Long idExamPart;
	
	@Column(name = "date", nullable = false)
	private Date date;
	
	@Column(name = "location", nullable = false)
	private String location;
	
	@Column(name = "points", nullable = false)
	private Integer points;
	
	@ManyToOne
	@JoinColumn(name = "exam", referencedColumnName = "idExam", nullable = false)
	private Exam exam;
	
	@ManyToOne
	@JoinColumn(name = "exam_part_type", referencedColumnName = "idExamPartType", nullable = false)
	private ExamPartType examPartType;
	
	@ManyToOne
	@JoinColumn(name = "exam_part_status", referencedColumnName = "idExamPartStatus", nullable = false)
	private ExamPartStatus examPartStatus;
	
	public ExamPart() {
		super();
	}

	public ExamPart(Long idExamPart, Date date, String location, Integer points, Exam exam, ExamPartType examPartType,
			ExamPartStatus examPartStatus) {
		super();
		this.idExamPart = idExamPart;
		this.date = date;
		this.location = location;
		this.points = points;
		this.exam = exam;
		this.examPartType = examPartType;
		this.examPartStatus = examPartStatus;
	}

	public Long getIdExamPart() {
		return idExamPart;
	}

	public void setIdExamPart(Long idExamPart) {
		this.idExamPart = idExamPart;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public ExamPartType getExamPartType() {
		return examPartType;
	}

	public void setExamPartType(ExamPartType examPartType) {
		this.examPartType = examPartType;
	}

	public ExamPartStatus getExamPartStatus() {
		return examPartStatus;
	}

	public void setExamPartStatus(ExamPartStatus examPartStatus) {
		this.examPartStatus = examPartStatus;
	}
	
}