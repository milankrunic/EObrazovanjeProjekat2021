package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface;


import java.util.List;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.ExamPart;

public interface ExamPartServiceInterface {


	void remove(ExamPart examPart);

	ExamPart save(ExamPart examPart);

	ExamPart findOne(Long id);

	List<ExamPart> findAllByExam(Long id);
	
}
