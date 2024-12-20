package com.ruriel.ldap.model;

import javax.naming.Name;

import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

import lombok.Getter;
import lombok.Setter;

@Entry(objectClasses = { "person", "inetOrgPerson", "top" }, base ="dc=techinterview,dc=com")
@Getter
@Setter
public class User {

	@Id
	private Name dn;
	
	private @Attribute(name = "cn") String cn;
	
	private @Attribute(name = "sn") String sn;
	
	private @Attribute(name = "email") String email;

}
