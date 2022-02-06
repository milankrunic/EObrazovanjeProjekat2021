package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.TeachingType;

public interface TeachingTypeRepository extends JpaRepository<TeachingType, Long>{

	TeachingType findByIdTeachingType(Long id);
	
}
