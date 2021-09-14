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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "exam_part_status")
public class ExamPartStatus extends JpaEntity {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "code", nullable = false)
	private String code;
	
	@OneToMany(cascade = {ALL}, fetch=LAZY, mappedBy="examPartStatus")
	private List<ExamPart> examPart = new ArrayList<ExamPart>();
	
	public ExamPartStatus() {
		super();
	}

	public ExamPartStatus(Long id, String name, String code, List<ExamPart> examPart) {
		super(id);
		this.name = name;
		this.code = code;
		this.examPart = examPart;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<ExamPart> getExamPart() {
		return examPart;
	}

	public void setExamPart(List<ExamPart> examPart) {
		this.examPart = examPart;
	}
}
