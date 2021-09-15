package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto;

import java.util.HashSet;
import java.util.Set;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Exam;

public class ExamDTO {
	
	private Long id;
	private Integer points;
	private Integer grade;
	private Set<ExamPartDTO> examParts = new HashSet<ExamPartDTO>();
	
	public ExamDTO() {
		super();
	}
	
	public ExamDTO(Long id, Integer points, Integer grade, Set<ExamPartDTO> examParts) {
		super();
		this.id = id;
		this.points = points;
		this.grade = grade;
		this.examParts = examParts;
	}
	
//	public ExamDTO(Exam exam) {
//		this(exam.getId(),exam.getPoints(),exam.getGrade(),exam.getExamPart());
//	}


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

	public Set<ExamPartDTO> getExamParts() {
		return examParts;
	}

	public void setExamParts(Set<ExamPartDTO> examParts) {
		this.examParts = examParts;
	}
	
	
}
