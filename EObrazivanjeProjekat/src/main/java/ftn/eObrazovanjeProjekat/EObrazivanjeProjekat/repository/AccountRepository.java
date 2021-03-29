package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Account;

public interface AccountRepository extends JpaRepository<Account,Long> {
	
	//Account findById(Long id);
//	Account remove(Long idAccount);
	Account findAllByStudent(Long id);
	
}
