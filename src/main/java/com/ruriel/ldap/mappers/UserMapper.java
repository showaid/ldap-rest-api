package com.ruriel.ldap.mappers;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InvalidNameException;

import org.springframework.ldap.support.LdapNameBuilder;
import org.springframework.stereotype.Component;

import com.ruriel.ldap.dto.UserDTO;
import com.ruriel.ldap.model.User;

@Component
public class UserMapper {
	public User mapUserDtoToUser(UserDTO userDto) throws InvalidNameException {
		User user = new User();
		user.setCn(userDto.getUsername());
		user.setSn(userDto.getLastName());
//		user.setDn(LdapUtils.emptyLdapName().add("ou=companyA").add("ou=team2").add("cn=" + user.getCn()));
		user.setDn(LdapNameBuilder.newInstance().add("ou", "companyA").add("ou", "team2")
				.add("cn", user.getCn()).build());
		user.setEmail(userDto.getEmail());
		return user;
	}
	
	public UserDTO mapUserToUserDto(User user) {
		UserDTO userDto = new UserDTO();
		userDto.setLastName(user.getSn());
		userDto.setOuDn(user.getDn().toString());
		userDto.setEmail(userDto.getEmail());
		return userDto;
	}
	
	public List<UserDTO> mapUserListToUserDtoList(List<User> userList) {
		ArrayList<UserDTO> userDtoList = new ArrayList<UserDTO>();
		userList.forEach(user -> {
			userDtoList.add(mapUserToUserDto(user));
		});
		
		return userDtoList;
	}
}
