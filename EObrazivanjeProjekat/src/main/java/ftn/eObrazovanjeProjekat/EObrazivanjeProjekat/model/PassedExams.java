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
@Table(name = "PassedExams")
public class PassedExams {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPassedExams", nullable = false, unique = true)
	private Long idPassedExams;
	
	@OneToMany(cascade = {ALL}, fetch=LAZY, mappedBy="passedExams")
	private List<CourseInstance> courseInstance = new ArrayList<CourseInstance>();

}
