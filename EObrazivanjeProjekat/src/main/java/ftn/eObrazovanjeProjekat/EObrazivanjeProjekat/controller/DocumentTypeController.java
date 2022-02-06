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

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto.DocumentTypeDTO;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.DocumentType;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.DocumentTypeServiceInterface;

@RestController
@RequestMapping(value = "api/document-type")
public class DocumentTypeController {
	
	@Autowired
	private DocumentTypeServiceInterface documentTypeServiceInterface;
	
	@GetMapping
	public ResponseEntity<List<DocumentTypeDTO>> getAllDocumentTypes(){
		List<DocumentType> types = documentTypeServiceInterface.findAll();
		
		List<DocumentTypeDTO> dtos = new ArrayList<DocumentTypeDTO>();
		
		for(DocumentType t : types) {
			dtos.add(new DocumentTypeDTO(t));
		}
		
		return new ResponseEntity<List<DocumentTypeDTO>>(dtos, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<DocumentTypeDTO> getOneTypeDocument(@PathVariable("id") Long id){
		DocumentType t = documentTypeServiceInterface.findById(id);
		if(t == null) {
			return new ResponseEntity<DocumentTypeDTO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<DocumentTypeDTO>(new DocumentTypeDTO(t), HttpStatus.OK);
	}
	
	@PutMapping(value = "/{id}", consumes = "application/json")
	@PreAuthorize("hasAnyRole('ROLE_ADMINISTRATOR')")
	public ResponseEntity<DocumentTypeDTO> updateTypeDocument(@RequestBody DocumentTypeDTO dto){
		DocumentType t = documentTypeServiceInterface.findById(dto.getIdDokumentType());
		
		if(t == null) {
			return new ResponseEntity<DocumentTypeDTO>(HttpStatus.NOT_FOUND);
		}
		t.setName(dto.getName());
		t.setCode(dto.getCode());
		t = documentTypeServiceInterface.save(t);
		return new ResponseEntity<DocumentTypeDTO>(new DocumentTypeDTO(t), HttpStatus.OK);
	}
	
	
	//teacherDTO?
	@PostMapping
	@PreAuthorize("hasAnyRole('ROLE_ADMINISTRATOR')")
	public ResponseEntity<DocumentTypeDTO> saveTypeDocument(@RequestBody DocumentTypeDTO dto){
		DocumentType t = new DocumentType();
		t.setName(dto.getName());
		t.setCode(dto.getCode());
		
		t = documentTypeServiceInterface.save(t);
		
		return new ResponseEntity<DocumentTypeDTO>(new DocumentTypeDTO(t), HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = "/{id}")
	@PreAuthorize("hasAnyRole('ROLE_ADMINISTRATOR')")
	public ResponseEntity<Void> deleteDocumentType(@PathVariable("id") Long id){
		DocumentType t = documentTypeServiceInterface.findById(id);
		
		if(t != null) {
			documentTypeServiceInterface.remove(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
}
