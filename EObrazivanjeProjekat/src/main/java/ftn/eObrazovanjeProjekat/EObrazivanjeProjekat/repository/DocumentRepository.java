package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {

	Page<Document> findByStudent_user_username(String username, Pageable page);

	
}
