package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.User;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.UserRole;
import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository.UserRepository;



@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;
  
  
  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByUsername(username);

    if (user == null) {
      throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
    } else {
    	List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
    	for (UserRole ur: user.getUserRoles()) {
    		grantedAuthorities.add(new SimpleGrantedAuthority(ur.getRole().getName()));
    	}
    	
    	//Java 1.8 way   	
    	/*List<GrantedAuthority> grantedAuthorities = user.getUserAuthorities().stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getAuthority().getName()))
                .collect(Collectors.toList());*/
    	
    	return new org.springframework.security.core.userdetails.User(
    		  user.getUsername(),
    		  user.getPassword(),
    		  grantedAuthorities);
    }
  }


//  @Override
//  @Transactional
//  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//    User user = userRepository.findByUsername(username);
//
//    if (user == null) {
//      throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
//    } else {
//    	List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
//    	grantedAuthorities.add(new SimpleGrantedAuthority(user.getUserRoles().toString()));
//
//    	UserDetails userDetails = new org.springframework.security.core.userdetails.User(
//    		  user.getUsername(),
//    		  user.getPassword(),
//    		  grantedAuthorities);
//    	return userDetails;
//    }
//  }

}
