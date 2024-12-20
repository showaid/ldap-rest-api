package com.ruriel.ldap.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private String ouDn;
}
