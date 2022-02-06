package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto;

import java.sql.Date;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.ExamPart;


public class ExamPartDTO {

	private Long id;
	private Date date;
	private String location;
	private Integer points;
	private ExamDTO examDTO;
	private ExamPartTypeDTO examPartTypeDTO;
	private ExamPartStatusDTO examPartStatusDTO;
	
	public ExamPartDTO(ExamPart examPart) {
		super();
	}

	public ExamPartDTO(Long id, Date date, String location, Integer points, ExamDTO examDTO, ExamPartTypeDTO examPartTypeDTO,
			ExamPartStatusDTO examPartStatusDTO) {
		super();
		this.id = id;
		this.date = date;
		this.location = location;
		this.points = points;
		this.examDTO = examDTO;
		this.examPartTypeDTO = examPartTypeDTO;
		this.examPartStatusDTO = examPartStatusDTO;
	}

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

	public ExamDTO getExamDTO() {
		return examDTO;
	}

	public void setExamDTO(ExamDTO examDTO) {
		this.examDTO = examDTO;
	}

	public ExamPartTypeDTO getExamPartTypeDTO() {
		return examPartTypeDTO;
	}

	public void setExamPartTypeDTO(ExamPartTypeDTO examPartTypeDTO) {
		this.examPartTypeDTO = examPartTypeDTO;
	}

	public ExamPartStatusDTO getExamPartStatusDTO() {
		return examPartStatusDTO;
	}

	public void setExamPartStatusDTO(ExamPartStatusDTO examPartStatusDTO) {
		this.examPartStatusDTO = examPartStatusDTO;
	}

	
	
}
