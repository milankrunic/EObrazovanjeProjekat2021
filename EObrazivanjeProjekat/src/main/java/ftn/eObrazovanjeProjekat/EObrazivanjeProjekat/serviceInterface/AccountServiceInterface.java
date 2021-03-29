package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Account;

public interface AccountServiceInterface {

	Account findAllByStudent(Long id);
	Account findOne(Long id);
	Account save(Account account);
	void remove(Long id);

}
