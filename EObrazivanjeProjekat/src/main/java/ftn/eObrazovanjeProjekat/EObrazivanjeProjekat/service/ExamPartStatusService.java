package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.ExamPartStatus;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository.ExamPartStatusRepository;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.ExamPartStatusServiceInterface;

public class ExamPartStatusService implements ExamPartStatusServiceInterface {

	@Autowired
	ExamPartStatusRepository examPartStatusRepository;
	
	@Override
	public List<ExamPartStatus> findAllByExamPart(Long id) {
		return examPartStatusRepository.findByExamPart_id(id);
	}

	@Override
	public ExamPartStatus findOne(Long id) {
		return examPartStatusRepository.getOne(id);
	}

	@Override
	public ExamPartStatus save(ExamPartStatus examPartStatus) {
		return examPartStatusRepository.save(examPartStatus);
	}

	@Override
	@Transactional
	public void remove(ExamPartStatus examPartStatus) {
		
		examPartStatusRepository.delete(examPartStatus);
	}
}
