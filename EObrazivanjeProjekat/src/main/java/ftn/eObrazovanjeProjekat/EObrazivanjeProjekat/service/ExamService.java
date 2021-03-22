package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Exam;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository.ExamRepository;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.ExamServiceInterface;

public class ExamService implements ExamServiceInterface {
	
	@Autowired
	ExamRepository examRepository;
	
	@Override
	public List<Exam> findAllByStudent(Long id) {
		return examRepository.findByStudent_id(id);
	}

	@Override
	public Exam findOne(Long id) {
		return examRepository.getOne(id);
	}

	@Override
	public Exam save(Exam exam) {
		return examRepository.save(exam);
	}

	@Override
	@Transactional
	public void remove(Exam exam) {
		
		examRepository.delete(exam);
	}

}
