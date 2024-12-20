package com.ruriel.ldap.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.naming.InvalidNameException;
import javax.naming.Name;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.DirContextAdapter;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.support.LdapNameBuilder;
import org.springframework.ldap.support.LdapUtils;
import org.springframework.stereotype.Service;

import com.ruriel.ldap.model.User;
import com.ruriel.ldap.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private LdapTemplate ldapTemplate;

	public User save(User user) {
		User ret = findByCn(user.getCn());
		if(ret == null)
			return userRepository.save(user);
		else
			return null;
	}
	
	public User saveUserToOu(User user, String ou) {
		User ret = findByCn(user.getCn());
		if (ret == null) {
			userRepository.saveUserToOu(user, ou);
			return findByCn(user.getCn());
		} else {
			return null;
		}
		
	}
	
	public void create(User user) {
		Name dn = LdapNameBuilder.newInstance().add("ou", "companyA")
				.add("ou", "team2")
				.add("cn", user.getCn()).build();
		
		DirContextAdapter context = new DirContextAdapter(dn);
		
		context.setAttributeValues(      
				"objectclass", 
			      new String[] 
			    	        { "top", 
			    	          "person", 
			    	          "organizationalPerson", 
			    	          "inetOrgPerson" });
		context.setAttributeValue("cn", user.getCn());
		context.setAttributeValue("sn", user.getSn());
		context.setAttributeValue("mail", user.getEmail());
		
		try {
			ldapTemplate.bind(context);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public User findByCn(String cn) {
		try {
			Optional<User> optional = userRepository.findById(LdapUtils.emptyLdapName().add("cn=" + cn));
			return optional.get();
		} catch (InvalidNameException e) {
			e.printStackTrace();
			return null;
		}
		catch(NoSuchElementException e) {
			return null;
		}
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public void delete(String cn) {
		Name id;
		try {
			id = LdapUtils.emptyLdapName().add("cn=" + cn);
		} catch (InvalidNameException e) {
			id = null;
			e.printStackTrace();
		}
		if (id != null)
			userRepository.deleteById(id);
	}
}
