package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
	
//	List<Admin> findAllAdmin(Long idAdmin);
	Admin findByIdAdmin(Long idAdmin);
//	Admin saveAdmin(Admin admin);
//	Admin addById(Long idAdmin);
//	Admin updateById(Long idAdmin);
//	Admin removeById(Long idAdmin);

//	Admin findOneByUser_user_name(String username);
}
