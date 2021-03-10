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
@Table(name = "courseSpecification")
public class CourseSpecification {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private Long id;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "ects", nullable = false)
	private Integer ects;
	
	@Column(name = "code", nullable = false)
	private String code;
	
	@OneToMany(cascade = {ALL}, fetch=LAZY, mappedBy="courseSpecification")
	private List<CourseInstance> courseInstance = new ArrayList<CourseInstance>();
	
	public CourseSpecification() {
		super();
	}

	public CourseSpecification(Long id, String title, Integer ects, String code,
			List<CourseInstance> courseInstance) {
		super();
		this.id = id;
		this.title = title;
		this.ects = ects;
		this.code = code;
		this.courseInstance = courseInstance;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getEcts() {
		return ects;
	}

	public void setEcts(Integer ects) {
		this.ects = ects;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<CourseInstance> getCourseInstance() {
		return courseInstance;
	}

	public void setCourseInstance(List<CourseInstance> courseInstance) {
		this.courseInstance = courseInstance;
	}

}
