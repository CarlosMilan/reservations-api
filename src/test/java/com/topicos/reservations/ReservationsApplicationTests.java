package com.topicos.reservations;

import com.topicos.reservations.domain.Address;
import com.topicos.reservations.domain.User;
import com.topicos.reservations.domain.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
class ReservationsApplicationTests {

	@Autowired
	private UserService userService;

	@Test
	void contextLoads() {
	}

	@Test
	public void insertUserTest() {
		/*

		User user = new User();
		Address address = new Address();
		address.setStreet("Mendoza 1466 Sur");
		address.setCity("Rawson");
		address.setProvince("San Juan");

		user.setName("Juan");
		user.setLastName("Peralta");
		user.setEmail("juan.peralta@correo.com");
		user.setAddress( address );
		
		user.setPhones(Arrays.asList("155777555"));
		
		User saveUser = userService.save( user );

		System.out.println("saveUser = " + saveUser);

		*/
	}
}
