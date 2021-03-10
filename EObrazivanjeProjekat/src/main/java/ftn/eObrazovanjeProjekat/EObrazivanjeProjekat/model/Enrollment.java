package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Enrollment")
public class Enrollment {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idEnrollment", nullable = false, unique = true)
	private Long idEnrollment;
	
	@ManyToOne
	@JoinColumn(name = "course_instance", referencedColumnName = "idCourseInstance", nullable = false)
	private CourseInstance courseInstance;

}
