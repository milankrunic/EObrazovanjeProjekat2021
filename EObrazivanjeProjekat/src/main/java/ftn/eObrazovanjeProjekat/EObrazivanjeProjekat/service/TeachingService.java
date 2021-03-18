package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Teaching;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository.TeachingRepository;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.TeachingServiceInterface;

@Service
public class TeachingService implements TeachingServiceInterface{
	
	@Autowired
	TeachingRepository teachingRepository;

	@Override
	public List<Teaching> findAll() {
		return teachingRepository.findAll();
	}

	@Override
	public Teaching findOne(Long id) {
		return teachingRepository.getOne(id);
	}

	@Override
	public Teaching findById(Long teachingId) {
		return teachingRepository.findByIdTeaching(teachingId);
	}

	@Override
	public Teaching save(Teaching teaching) {
		return teachingRepository.save(teaching);
	}

	@Override
	public void remove(Long id) {
		teachingRepository.deleteById(id);
		
	}

}
