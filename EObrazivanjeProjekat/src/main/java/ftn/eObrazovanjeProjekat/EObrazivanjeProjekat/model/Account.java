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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account extends JpaEntity {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "amount", nullable = false)
	private Double amount;
	
	@ManyToOne
	@JoinColumn(name = "student", referencedColumnName = "idStudent", nullable = false)
	private Student student;
	
	@OneToMany(cascade = {ALL}, fetch=LAZY, mappedBy="account")
	private List<StudentPayments> studentPayments = new ArrayList<StudentPayments>();
	
	public Account() {
		super();
	}

	public Account(Long id, Double amount, Student student, List<StudentPayments> studentPayments) {
		super(id);
		this.amount = amount;
		this.student = student;
		this.studentPayments = studentPayments;
	}


	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<StudentPayments> getStudentPayments() {
		return studentPayments;
	}

	public void setStudentPayments(List<StudentPayments> studentPayments) {
		this.studentPayments = studentPayments;
	}

}
