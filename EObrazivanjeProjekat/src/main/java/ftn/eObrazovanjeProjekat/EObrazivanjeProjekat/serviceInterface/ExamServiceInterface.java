package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface;

import java.util.List;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Exam;

public interface ExamServiceInterface {

	Exam save(Exam exam);

	void remove(Exam exam);

	List<Exam> findAllByStudent(Long id);

	Exam findOne(Long id);

}
