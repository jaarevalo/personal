package com.jarevalodev.notazas;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.test.util.AssertionErrors.assertTrue;

@SpringBootTest
class NotazasApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void should_do_stuff(){
		System.out.println("hi");
		assertTrue("This will succeed.", true);
	}

}
