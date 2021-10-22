package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.service;

import java.util.List;

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
		return documentTypeRepository.getOne(id);
	}

	@Override
	public void remove(Long id) {
		documentTypeRepository.deleteById(id);
		
	}

	@Override
	public DocumentType findById(Long id) {
		return documentTypeRepository.findByIdDokumentType(id);
	}

	@Override
	public DocumentType save(DocumentType documentType) {
		return documentTypeRepository.save(documentType);
	}

	@Override
	public List<DocumentType> findAll() {
		// TODO Auto-generated method stub
		return documentTypeRepository.findAll();
	}

	@Override
	public DocumentType docTypeByCode(String code) {
		// TODO Auto-generated method stub
		return documentTypeRepository.findOneByCode(code);
	}

}
