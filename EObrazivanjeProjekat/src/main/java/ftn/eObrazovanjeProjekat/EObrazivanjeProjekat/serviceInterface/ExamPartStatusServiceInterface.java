package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface;

import java.util.List;


import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.ExamPartStatus;

public interface ExamPartStatusServiceInterface {

	void remove(ExamPartStatus examPartStatus);

	ExamPartStatus save(ExamPartStatus examPartStatus);

	List<ExamPartStatus> findAllByExamPart(Long id);

	ExamPartStatus findOne(Long id);

}
