package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.DocumentType;

public interface DocumentTypeServiceInterface {

	public DocumentType findOne(Long id);
	public void remove(Long id);
	public DocumentType findById(Long id);
	public DocumentType save(DocumentType documentType);
}
