package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.ExamPart;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository.ExamPartRepository;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.ExamPartServiceInterface;

public class ExamPartService implements ExamPartServiceInterface {
	
	@Autowired
	ExamPartRepository examPartRepository;
	
	@Override
	public List<ExamPart> findAllByExam(Long id) {
		return examPartRepository.findByIdExamPart(id);
	}

	@Override
	public ExamPart findOne(Long id) {
		return examPartRepository.getOne(id);
	}

	@Override
	public ExamPart save(ExamPart examPart) {
		return examPartRepository.save(examPart);
	}

	@Override
	@Transactional
	public void remove(ExamPart examPart) {
		
		examPartRepository.delete(examPart);
	}

}
