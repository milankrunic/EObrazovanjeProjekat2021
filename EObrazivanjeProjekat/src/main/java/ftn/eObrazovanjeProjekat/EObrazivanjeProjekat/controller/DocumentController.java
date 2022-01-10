package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto.DocumentDTO;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto.StudentDTO;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Document;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.DocumentType;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Student;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.DocumentServiceInterface;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.DocumentTypeServiceInterface;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.StudentServiceInterface;


@RestController
@RequestMapping(value = "api/document")
public class DocumentController {

	@Autowired
	DocumentServiceInterface documentServiceInterface;
	
	@Autowired 
	StudentServiceInterface studentServiceInterface;
	
	@Autowired 
	DocumentTypeServiceInterface documentTypeServiceInterface;

	
	@GetMapping
	@PreAuthorize("hasAnyRole('ROLE_STUDENT')")
	public ResponseEntity<List<DocumentDTO>> getAllDocumentsByStudent(Principal principal,Pageable page){
		System.out.println("\ngetAllDocumentsByStudent");
		
		Page<Document> documents = documentServiceInterface.findByUsername(principal.getName(),page);
		List<DocumentDTO> dtos = new ArrayList<DocumentDTO>();
		
		for (Document document : documents) {
			dtos.add(new DocumentDTO(document));
		}
		return new ResponseEntity<List<DocumentDTO>>(dtos, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<DocumentDTO> getOneDocument(@PathVariable("id") Long id){
		Document document = documentServiceInterface.findOne(id);
		if(document == null) {
			return new ResponseEntity<DocumentDTO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<DocumentDTO>(new DocumentDTO(document), HttpStatus.OK);
	}
	
	
	
	@PutMapping()
	@PreAuthorize("hasAnyRole('ROLE_STUDENT', 'ROLE_ADMINISTRATOR')")
	public ResponseEntity<DocumentDTO> updateDocument(@RequestBody DocumentDTO dto){
		
		Student student = studentServiceInterface.findById(dto.getStudentDTO().getId());
		DocumentType typeDocument = documentTypeServiceInterface.findById(dto.getDokumentTypeDTO().getIdDokumentType());
		Document document = documentServiceInterface.findOne(dto.getIdDokument());
		if(document == null) {
			return new ResponseEntity<DocumentDTO>(HttpStatus.NOT_FOUND);
		}
		document.setTitle(dto.getTitle());
		document.setUrl(dto.getUrl());
		document.setStudent(student);
		document.setDokumentType(typeDocument);
		document = documentServiceInterface.save(document);
		return new ResponseEntity<DocumentDTO>(new DocumentDTO(document), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteDocument(@PathVariable("id") Long id){
		
		Document document = documentServiceInterface.findOne(id);
		if(document != null) {
			documentServiceInterface.remove(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
}
