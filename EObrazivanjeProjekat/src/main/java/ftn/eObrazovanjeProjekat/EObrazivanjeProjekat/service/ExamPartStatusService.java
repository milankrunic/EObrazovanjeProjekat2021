package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.ExamPartStatus;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository.ExamPartStatusRepository;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.ExamPartStatusServiceInterface;

@Service
public class ExamPartStatusService implements ExamPartStatusServiceInterface {

	@Autowired
	ExamPartStatusRepository examPartStatusRepository;
	
	@Override
	public List<ExamPartStatus> findAllByExamPart(Long id) {
		return examPartStatusRepository.findByIdExamPartStatus(id);
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

	@Override
	public ExamPartStatus examPartStatusByCode(String code) {
		// TODO Auto-generated method stub
		return examPartStatusRepository.findOneByCode(code);
	}

	@Override
	public List<ExamPartStatus> findAll() {
		// TODO Auto-generated method stub
		return examPartStatusRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		 examPartStatusRepository.deleteById(id);
		
	}
}
