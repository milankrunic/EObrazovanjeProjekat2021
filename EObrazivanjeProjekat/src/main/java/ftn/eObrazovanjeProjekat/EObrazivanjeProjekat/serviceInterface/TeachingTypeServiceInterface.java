package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface;

import java.util.List;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.TeachingType;

public interface TeachingTypeServiceInterface {
	
	public List<TeachingType> findAll();
	public TeachingType findOne(Long id);
	public TeachingType findById(Long teachingTypeId);
	public TeachingType save(TeachingType teachingType);
	public void remove(Long id);

}
