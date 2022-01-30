package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.UserRole;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository.UserRoleRepository;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.UserRoleServiceInterface;

@Service
public class UserRoleService implements UserRoleServiceInterface{

	@Autowired
	UserRoleRepository repository;
	
	@Override
	public void deleteByUser(Long id) {
		repository.deleteByUser_id(id);
	}

	@Override
	public List<UserRole> findAllUserRole(Long id) {
		return repository.findUserRoleByUser_id(id);
	}

	@Override
	public void deleteUserRole(UserRole userRole) {
		repository.delete(userRole);
	}

	@Override
	public UserRole findUserRoleByUserAndRole(Long id, String code) {
		return repository.findUserRoleByUser_idAndRole_code(id, code);
	}

}
