package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.DocumentType;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository.DocumentTypeRepository;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.DocumentTypeServiceInterface;

@Service
public class DocumentTypeService implements DocumentTypeServiceInterface {

	@Autowired
	DocumentTypeRepository documentTypeRepository;
	@Override
	public DocumentType findOne(Long id) {
		return documentTypeRepository.findOne(id);
	}

	@Override
	public void remove(Long id) {
		documentTypeRepository.deleteById(id);
		
	}

	@Override
	public DocumentType findById(Long id) {
		return documentTypeRepository.findByIdDocumentType(id);
	}

	@Override
	public DocumentType save(DocumentType documentType) {
		return documentTypeRepository.saveDocumentType(documentType);
	}

}
