package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
		return documentRepository.getOne(id);
	}

	@Override
	public void remove(Long id) {
		documentRepository.deleteById(id);
		
	}

	@Override
	public Document save(Document document) {
		return documentRepository.save(document);
	}
	
	@Override
	public Page<Document> findByUsername(String username,Pageable page) {
		// TODO Auto-generated method stub
		return documentRepository.findByStudent_user_username(username,page);
	}
	

}
