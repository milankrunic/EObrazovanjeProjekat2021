package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface;

import java.util.List;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Role;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.UserRole;

public interface UserRoleServiceInterface {

	List<UserRole> findAllUserRole(Long id);
	void deleteByUser(Long id);
	void deleteUserRole(UserRole userRole);
	UserRole findUserRoleByUserAndRole(Long id,String code);
}
