package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface;

import java.util.List;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.DocumentType;

public interface DocumentTypeServiceInterface {

	public List<DocumentType> findAll();
	public DocumentType findOne(Long id);
	public void remove(Long id);
	public DocumentType findById(Long id);
	public DocumentType save(DocumentType documentType);
	public DocumentType docTypeByCode(String code);
}
