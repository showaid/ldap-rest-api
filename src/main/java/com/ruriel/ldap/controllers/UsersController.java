package com.ruriel.ldap.controllers;

import java.util.List;

import javax.naming.InvalidNameException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ruriel.ldap.dto.ResponseDTO;
import com.ruriel.ldap.dto.UserDTO;
import com.ruriel.ldap.mappers.UserMapper;
import com.ruriel.ldap.model.User;
import com.ruriel.ldap.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UsersController {

	@Autowired
	UserService service;
	
	@Autowired
	UserMapper mapper;

//	@PostMapping("/users")
//	public ResponseDTO saveUser(@RequestBody UserDTO userDTO) {
//		User user = null;
//		try {
//			user = mapper.mapUserDtoToUser(userDTO);
//			log.info("User {}", user);
////			service.create(user);
//			user = service.save(user);
//		} catch (InvalidNameException e) {
//			e.printStackTrace();
//			user = null;
//		}
//		ResponseDTO dto = new ResponseDTO();
//		if (user == null)
//			dto.setMessage("Unable to persist user.");
//		else {
//			dto.setMessage("User persisted successfully.");
//			dto.addUser(mapper.mapUserToUserDto(user));
//		}
//		return dto;
//	}
//	
//	@GetMapping("/users")
//	public ResponseDTO getUsers() {
//		ResponseDTO dto = new ResponseDTO();
//		List<User> users = service.findAll();
//		if (users == null || users.size() == 0) {
//			dto.setMessage("No users found");
//		} else {
//			List<UserDTO> userDtos = mapper.mapUserListToUserDtoList(users);
//			int size = userDtos.size();
//			if (size == 1)
//				dto.setMessage("1 user found.");
//			else
//				dto.setMessage("Found " + users.size() + " users.");
//			dto.setUsers(userDtos);
//		}
//		return dto;
//	}
////
//	@GetMapping("/users/{cn}")
//	public ResponseDTO getUser(@PathVariable String cn) {
//		ResponseDTO dto = new ResponseDTO();
//		User user = service.findByCn(cn);
//		if (user == null) {
//			dto.setMessage("No users found.");
//		} else {
//			dto.setMessage("User found successfully.");
//			dto.addUser(mapper.mapUserToUserDto(user));
//		}
//		return dto;
//	}
//
//	@DeleteMapping("/users/{cn}")
//	public ResponseDTO deleteUser(@PathVariable String cn) {
//		ResponseDTO dto = new ResponseDTO();
//		User user = service.findByCn(cn);
//		if (user == null)
//			dto.setMessage("No users found.");
//		else {
//			service.delete(cn);
//			dto.setMessage("User removed.");
//		}
//		return dto;
//	}

}
