package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Document;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository.DocumentRepository;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.DocumentServiceInterface;

@Service
public class DocumentService implements DocumentServiceInterface {

	
	@Autowired
	DocumentRepository documentRepository;
	
	@Override
	public List<Document> findAll() {
		return documentRepository.findAll();
	}

	@Override
	public Document findOne(Long id) {
		return documentRepository.findByIdDocument(id);
	}

	@Override
	public void remove(Long id) {
		documentRepository.deleteById(id);
		
	}

	@Override
	public Document save(Document document) {
		return documentRepository.saveDocument(document);
	}

}
