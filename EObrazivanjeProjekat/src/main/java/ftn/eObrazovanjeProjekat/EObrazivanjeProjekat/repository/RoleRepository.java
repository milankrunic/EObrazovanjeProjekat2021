package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findOneByCode(String code);
}
