package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto;

import java.sql.Date;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Exam;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.ExamPart;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.ExamPartStatus;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.ExamPartType;

public class ExamPartDTO {

	private Long id;
	private Date date;
	private String location;
	private Integer points;
	private Exam exam;
	private ExamPartType examPartType;
	private ExamPartStatus examPartStatus;
	
	public ExamPartDTO() {
		super();
	}

	public ExamPartDTO(Long id, Date date, String location, Integer points, Exam exam, ExamPartType examPartType,
			ExamPartStatus examPartStatus) {
		super();
		this.id = id;
		this.date = date;
		this.location = location;
		this.points = points;
		this.exam = exam;
		this.examPartType = examPartType;
		this.examPartStatus = examPartStatus;
	}
	
//	public ExamPartDTO(ExamPart ep) {
//		this(ep.getId(),ep.getDate(),ep.getLocation(),ep.getPoints(),ep.getExam(),ep.getExamPartType(),ep.getExamPartStatus());
//	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
