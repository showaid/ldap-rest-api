package com.ruriel.ldap.repository;

import org.springframework.data.rest.core.annotation.RestResource;

import com.ruriel.ldap.model.User;

public interface CustomUserRepository {
	@RestResource(path = "saveUserToOu", rel = "saveUserToOu")
	User saveUserToOu(User user, String organizationalUnit);
}
