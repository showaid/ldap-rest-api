package com.ruriel.ldap.repository;

import org.springframework.data.ldap.repository.LdapRepository;
import org.springframework.stereotype.Repository;

import com.ruriel.ldap.model.User;

@Repository
public interface UserRepository extends LdapRepository<User>, CustomUserRepository{

}
