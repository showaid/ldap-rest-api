package com.ruriel.ldap.repository;

import javax.naming.Name;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.support.LdapNameBuilder;
import org.springframework.stereotype.Component;

import com.ruriel.ldap.model.User;

@Component
public class CustomUserRepositoryImpl implements CustomUserRepository {
	
	@Autowired
	private LdapTemplate ldapTemplate;

	@Override
	public User saveUserToOu(User user, String organizationalUnit) {
		
		Name dn = LdapNameBuilder.newInstance()
				.add("ou", organizationalUnit)
				.add("cn", user.getCn())
				.build();
		
		user.setDn(dn);
		
		ldapTemplate.create(user);
		
		return user;
	}

}
