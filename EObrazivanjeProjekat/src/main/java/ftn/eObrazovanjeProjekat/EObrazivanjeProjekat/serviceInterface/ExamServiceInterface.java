package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface;

import java.util.List;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Exam;

public interface ExamServiceInterface {

	Exam save(Exam exam);

	void remove(Exam exam);

	Exam findOne(Long id);


}
