package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface;

import java.util.List;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.ExamPartType;

public interface ExamPartTypeServiceInterface {

	List<ExamPartType> findAllByExamPart(Long id);

	ExamPartType findOne(Long id);

	ExamPartType save(ExamPartType examPartType);

	void remove(ExamPartType examPartType);
	
	public List<ExamPartType> findAll();
	
	public ExamPartType findByCode(String code);
	
	public void delete(Long id);

}
