package com.ruriel.ldap.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ruriel.ldap.model.User;

@SpringBootTest
class CustomUserRepositoryImplTest {

	@Autowired
	private UserRepository userRepository;
	
	@Test
	void testSaveUserToOu() {
		
		User user = new User();
		user.setCn("test");
		user.setSn("John");
//		user.setEmail("test@example.com");
		String dynamicOu = "companyA";
		
		userRepository.saveUserToOu(user, dynamicOu);
	}

}
