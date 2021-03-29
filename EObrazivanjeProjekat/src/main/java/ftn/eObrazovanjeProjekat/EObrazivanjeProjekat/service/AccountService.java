package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Account;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository.AccountRepository;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface.AccountServiceInterface;

@Service
public class AccountService implements AccountServiceInterface {
	
	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public Account findAllByStudent(Long id) {
		return accountRepository.findAllByStudent(id);
	}
	
	@Override
	public Account findOne(Long id) {
		return accountRepository.findOne(id);
	}
	
	
	@Override
	public Account save(Account account) {
		return accountRepository.save(account);
	}
	
	@Override
	@Transactional
	public void remove(Long id) {
		accountRepository.deleteById(id);
	}
	
	public Account updateAccount(Account account) {
		Account accountUpdate = accountRepository.findById(account.getIdAccount()).get();
				accountUpdate.setAmount(account.getAmount());
				accountUpdate.setStudent(account.getStudent());
				accountUpdate.setStudentPayments(account.getStudentPayments());
			
				return accountUpdate;
	}
	
}
