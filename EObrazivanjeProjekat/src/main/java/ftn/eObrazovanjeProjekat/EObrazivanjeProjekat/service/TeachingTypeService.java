package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.TeachingType;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository.TeachingTypeRepository;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.TeachingTypeServiceInterface;

@Service
public class TeachingTypeService implements TeachingTypeServiceInterface{
	
	@Autowired
	TeachingTypeRepository teachingTypeRepository;

	@Override
	public List<TeachingType> findAll() {
		return teachingTypeRepository.findAll();
	}

	@Override
	public TeachingType findOne(Long id) {
		return teachingTypeRepository.getOne(id);
	}

	@Override
	public TeachingType findById(Long teachingTypeId) {
		return teachingTypeRepository.findByIdTeachingType(teachingTypeId);
	}

	@Override
	public TeachingType save(TeachingType teachingType) {
		return teachingTypeRepository.save(teachingType);
	}

	@Override
	public void remove(Long id) {
		teachingTypeRepository.deleteById(id);
		
	}

}
