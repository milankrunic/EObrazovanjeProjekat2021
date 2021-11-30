package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.ExamPart;

public interface ExamPartServiceInterface {


	void remove(ExamPart examPart);

	ExamPart save(ExamPart examPart);

	ExamPart findOne(Long id);

	List<ExamPart> findAllByExam(Long id);

	ExamPart add(ExamPart newExamPart);

	Page<ExamPart> findByCourseInstance(Long courseId, Pageable page);

	List<ExamPart> findByCodeAndCardNum(String code, String cardNum);

	
	
}
