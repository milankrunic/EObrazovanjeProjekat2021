package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.serviceInterface;

import java.util.List;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.User;

public interface UserServiceInterface {

	public List<User> findAll();
	public User findOne(Long id);
	public User findById(Long userId);
	public User save(User user);
	public void remove(Long id);
	
}
