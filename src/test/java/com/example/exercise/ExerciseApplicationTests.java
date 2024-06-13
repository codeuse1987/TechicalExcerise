package com.example.exercise;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class ExerciseApplicationTests {

	@Test
	void contextLoads() {
	}
	private static Logger logger = LoggerFactory.getLogger(ExerciseApplicationTests.class);
	String message = "BrowserStack is the intended message";

	@Test
	public void testCaseOne() {
		System.out.println("TestCase One Started");
		//test function , expected test result
		assertEquals(message, "BrowserStack is the intended message");
		logger.debug("Test Result");
	}

}
