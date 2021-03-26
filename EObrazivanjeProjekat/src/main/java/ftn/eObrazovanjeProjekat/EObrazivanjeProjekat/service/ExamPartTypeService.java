package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.ExamPartType;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository.ExamPartTypeRepository;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.ExamPartTypeServiceInterface;

public class ExamPartTypeService implements ExamPartTypeServiceInterface {
	
	@Autowired
	ExamPartTypeRepository examPartTypeRepository;
	
	@Override
	public List<ExamPartType> findAllByExamPart(Long id) {
		return examPartTypeRepository.findByIdExamPartType(id);
	}

	@Override
	public ExamPartType findOne(Long id) {
		return examPartTypeRepository.getOne(id);
	}

	@Override
	public ExamPartType save(ExamPartType examPartType) {
		return examPartTypeRepository.save(examPartType);
	}

	@Override
	@Transactional
	public void remove(ExamPartType examPartType) {
		
		examPartTypeRepository.delete(examPartType);
	}
}
