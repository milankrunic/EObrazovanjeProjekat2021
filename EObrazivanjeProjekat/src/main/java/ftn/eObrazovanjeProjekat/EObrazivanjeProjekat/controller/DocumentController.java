package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Student;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.DocumentServiceInterface;

@RestController
@RequestMapping(value = "api/document")
public class DocumentController {

	@Autowired
	DocumentServiceInterface documentServiceInterface;

	
//	@GetMapping(value ="/{id}")
//	public ResponseEntity<DocumentDTO> getDocumentByStudent(@PathVariable("id") Long id){
//		
//		Document document = documentServiceInterface.findOne(id);
//		
//		if(document == null) {
//			return new ResponseEntity<DocumentDTO>(HttpStatus.NOT_FOUND);
//		}
//		
//		return new ResponseEntity<DocumentDTO>(new DocumentDTO(document),HttpStatus.OK);
//	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<DocumentDTO> getOneDocument(@PathVariable("id") Long id){
		Document document = documentServiceInterface.findOne(id);
		if(document == null) {
			return new ResponseEntity<DocumentDTO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<DocumentDTO>(new DocumentDTO(document), HttpStatus.OK);
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<DocumentDTO> addDocument(@RequestBody DocumentDTO documentDTO){
		
		Document doc = new Document();
		doc.setTitle(documentDTO.getTitle());
		doc.setDokumentType(documentDTO.getDokumentType());
		doc.setUrl(documentDTO.getUrl());
		doc.setStudent(documentDTO.getStudent());
		
		doc = documentServiceInterface.save(doc);
		return new ResponseEntity<DocumentDTO>(new DocumentDTO(doc),HttpStatus.CREATED);
	}
	
	@PutMapping(value ="/{id}",consumes = "application/json")
	public ResponseEntity<DocumentDTO> updateDocument(@RequestBody DocumentDTO documentDTO,@PathVariable("id") Long id){
		
		Document document = documentServiceInterface.findOne(id);
		
		if(document == null) {
			return new ResponseEntity<DocumentDTO>(HttpStatus.BAD_REQUEST);
		}
		
		document.setTitle(documentDTO.getTitle());
		document.setDokumentType(documentDTO.getDokumentType());
		document.setUrl(documentDTO.getUrl());
		document.setStudent(documentDTO.getStudent());
		
		document = documentServiceInterface.save(document);
		
		return new ResponseEntity<DocumentDTO>(new DocumentDTO(document),HttpStatus.OK);
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
