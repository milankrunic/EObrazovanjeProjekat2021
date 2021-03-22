package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.DocumentType;


public interface DocumentTypeRepository extends JpaRepository<DocumentType, Long> {
	
	DocumentType findByIdDocumentType(Long id);
	DocumentType removeById(Long id);
	DocumentType addById(Long id);
	DocumentType updateById(Long id);
	DocumentType findOne(Long id);
	DocumentType saveDocumentType(DocumentType documentType);
}
