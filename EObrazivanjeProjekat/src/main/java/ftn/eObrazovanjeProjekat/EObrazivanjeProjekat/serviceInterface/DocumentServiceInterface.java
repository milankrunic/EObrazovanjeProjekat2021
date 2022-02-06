package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Document;

public interface DocumentServiceInterface {
	
	public List<Document> findAll();
	public Document findOne(Long id);
	public void remove(Long id);
	public Document save(Document document);
	Page<Document> findByUsername(String username, Pageable page);
}
