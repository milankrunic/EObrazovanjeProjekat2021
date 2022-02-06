package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Role;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository.RoleRepository;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.RoleServiceInterface;

@Service
public class RoleService implements RoleServiceInterface {

	@Autowired
	RoleRepository repository;
	
	@Override
	public List<Role> findAll() {
		return repository.findAll();
	}

	@Override
	public Role findById(Long id) {
		return repository.getOne(id);
	}

	@Override
	public Role save(Role userRole) {
		return repository.save(userRole);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

	@Override
	public Role findByCode(String code) {
		return repository.findOneByCode(code);
	}

}
