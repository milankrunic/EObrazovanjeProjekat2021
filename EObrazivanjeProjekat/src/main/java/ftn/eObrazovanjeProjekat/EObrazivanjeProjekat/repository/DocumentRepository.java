package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {

//	List<Document> findAllDocument(Long id);
//	Document saveDocument(Document document);
//	Document findByIdDokument(Long idDokument);
//	Document removeByIdDocument(Long id);
}
