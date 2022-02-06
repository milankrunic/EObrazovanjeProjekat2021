package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface;

import java.util.List;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Role;

public interface RoleServiceInterface {
	
	public List<Role> findAll();
	
	public Role findById(Long id);
	
	public Role save(Role userRole);
	
	public void delete(Long id);
	
	public Role findByCode(String code);
}
