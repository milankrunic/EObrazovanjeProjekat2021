package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.UserRole;


public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
	void deleteByUser_id(Long id);
	List<UserRole> findUserRoleByUser_id(Long id);
	UserRole findUserRoleByUser_idAndRole_code(Long id,String code);
}
