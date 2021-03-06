package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.ExamPart;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository.ExamPartRepository;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.ExamPartServiceInterface;

@Service
public class ExamPartService implements ExamPartServiceInterface {
	
	@Autowired
	ExamPartRepository examPartRepository;
	
	@Override
	public List<ExamPart> findAllByExam(Long id) {
		return examPartRepository.findByExam(id);
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

	@Override
	public ExamPart add(ExamPart newExamPart) {
		ExamPart examPart = new ExamPart();
		examPart.setDate(newExamPart.getDate());
		examPart.setLocation(newExamPart.getLocation());
		examPart.setExam(newExamPart.getExam());
		examPart.setPoints(newExamPart.getPoints());
		examPart.setExamPartType(newExamPart.getExamPartType());
		examPart.setExamPartStatus(newExamPart.getExamPartStatus());
		
		examPart = this.examPartRepository.save(examPart);
		return examPart;
	}
}
