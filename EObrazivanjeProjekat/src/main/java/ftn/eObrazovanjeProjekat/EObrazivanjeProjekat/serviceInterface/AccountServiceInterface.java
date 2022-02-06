package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface;

import java.util.List;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Account;

public interface AccountServiceInterface {

	Account findAllByStudent(Long id);
	Account findOne(Long id);
	Account save(Account account);
	void remove(Long id);
	List<Account> findByUsername(String username);
	

}
