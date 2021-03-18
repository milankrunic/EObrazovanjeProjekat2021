package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface;

import java.util.List;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Teaching;

public interface TeachingServiceInterface {
	
	public List<Teaching> findAll();
	public Teaching findOne(Long id);
	public Teaching findById(Long teachingId);
	public Teaching save(Teaching teaching);
	public void remove(Long id);

}
