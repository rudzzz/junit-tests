package dev.rudzzz.tests;

import dev.rudzzz.tests.entities.User;
import dev.rudzzz.tests.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TestsApplicationTests {

	@Autowired
	private UserService userService;
	private TestRestTemplate testRestTemplate;

	// Unit Tests
	/*@Test
	public void createUserSuccess(){
		User user = new User("Acir", "123");

		List<User> users = userService.create(user);

		assertEquals(1, users.size());
		assertEquals(user, users.get(0));
	}

	@Test
	public void createUserFailure(){
		User user = new User("acir", "123");

		userService.create(user);

		assertThrows(RuntimeException.class, () -> userService.create(user));
	}*/

	//Integration Tests
	@Test
	public void createUser(){
		User user = new User("acir", "123");

		User[] users = testRestTemplate.postForObject("/users", user, User[].class);

		assertNotNull(users);
		assertEquals(1, users.length);
		assertEquals(user, users[0]);
		assertThrows(RuntimeException.class
				, () -> testRestTemplate.postForObject("/users", user, User[].class)
		);
	}
}
