package com.ruriel.ldap;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
//import org.junit.After;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ruriel.ldap.controllers.UsersController;
import com.ruriel.ldap.dto.ResponseDTO;
import com.ruriel.ldap.dto.UserDTO;

@SpringBootTest
class LdapRestApiApplicationTests {

	@Autowired
	private UsersController controller;
	
	@MockBean
	private UserDTO userDto;
	
	@BeforeEach
	void prepare() {
		when(userDto.getUsername()).thenReturn("Beta");
	}
	
//	@AfterEach
//	void removeUser() {
////		userService.delete("Beta");
//		controller.deleteUser(userDto.getUsername());
//	}
//
//	@Test
//	void testSaveUser() {
//		ResponseDTO saveUser = controller.saveUser(userDto);
//		assertEquals(saveUser, notNullValue());
//	}

//	@Test
//	void testFindByUid() {
//		User user = new User();
//		user.setCn("Testing pilot");
//		user.setSn("Testing");
//		userService.save(user);
//		User found = userService.findByCn(user.getCn());
//		assertEquals(found, notNullValue());
//	}
//
//	@Test
//	void testFindAll() {
//		User user = new User();
//		user.setCn("Testing pilot");
//		user.setSn("Testing");
//		userService.save(user);
//		List<User> found = userService.findAll();
//		assertTrue(found.size() > 0);
//	}
//	
//	@Test
//	void testDelete() {
//		User user = new User();
//		user.setCn("Testing pilot");
//		user.setSn("Testing");
//		userService.save(user);
//		userService.delete(user.getCn());
//		User found = userService.findByCn(user.getCn());
//		assertEquals(found, nullValue());
//	}
}
