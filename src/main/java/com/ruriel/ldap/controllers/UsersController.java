package com.ruriel.ldap.controllers;

import java.util.List;

import javax.naming.InvalidNameException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruriel.ldap.dto.ResponseDTO;
import com.ruriel.ldap.model.User;
import com.ruriel.ldap.repository.UserService;

@RestController
public class UsersController {

	@Autowired
	UserService service;

	@PostMapping("/Users")
	public ResponseDTO saveUser(@Valid @RequestBody User user) {
		User ret;
		try {
			ret = service.create(user);
		} catch (InvalidNameException e) {
			e.printStackTrace();
			ret = null;
		}
		ResponseDTO dto = new ResponseDTO();
		if (ret == null)
			dto.setMessage("Unable to persist user.");
		else {
			dto.setMessage("User persisted successfully.");
			dto.addUser(ret);
		}
		return dto;
	}

	@GetMapping("/Users")
	public ResponseDTO getUsers() {
		ResponseDTO dto = new ResponseDTO();
		List<User> users = service.findAll();
		if (users == null || users.size() == 0) {
			dto.setMessage("No users found");
		} else {
			int size = users.size();
			if (size == 1)
				dto.setMessage("1 user found.");
			else
				dto.setMessage("Found " + users.size() + " users.");
			dto.setUsers(users);
		}
		return dto;
	}

	@GetMapping("/Users/{uid}")
	public ResponseDTO getUser(@PathVariable String uid) {
		ResponseDTO dto = new ResponseDTO();
		User user = service.findByUid(uid);
		if (user == null) {
			dto.setMessage("No users found.");
		} else {
			dto.setMessage("User found successfully.");
			dto.addUser(user);
		}
		return dto;
	}

	@DeleteMapping("/Users/{uid}")
	public ResponseDTO deleteUser(@PathVariable String uid) {
		ResponseDTO dto = new ResponseDTO();
		User user = service.findByUid(uid);
		if (user == null)
			dto.setMessage("No users found.");
		else {
			service.delete(uid);
			dto.setMessage("User removed.");
		}
		return dto;
	}

}
