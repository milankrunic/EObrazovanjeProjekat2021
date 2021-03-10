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
@Table(name = "Teaching_type")
public class TeachingType {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idTeachingType", nullable = false, unique = true)
	private Long idTeachingType;
	
	@Column(name = "name_teaching_type", nullable = false)
	private String name;
	
	@Column(name = "code", nullable = false)
	private String code;
	
	@OneToMany(cascade = {ALL}, fetch=LAZY, mappedBy="teachingType")
	private List<Teaching> teaching = new ArrayList<Teaching>();
	
	public TeachingType() {
		super();
	}

	public TeachingType(Long idTeachingType, String name, String code, List<Teaching> teaching) {
		super();
		this.idTeachingType = idTeachingType;
		this.name = name;
		this.code = code;
		this.teaching = teaching;
	}

	public Long getIdTeachingType() {
		return idTeachingType;
	}

	public void setIdTeachingType(Long idTeachingType) {
		this.idTeachingType = idTeachingType;
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

	public List<Teaching> getTeaching() {
		return teaching;
	}

	public void setTeaching(List<Teaching> teaching) {
		this.teaching = teaching;
	}
}
