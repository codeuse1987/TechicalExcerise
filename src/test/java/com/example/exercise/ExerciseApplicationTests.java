package com.example.exercise;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.example.exercise.enity.Vehicle;
import com.example.exercise.model.Vehicles;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@SpringBootTest
@AutoConfigureMockMvc
class ExerciseApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	private static Logger logger = LoggerFactory.getLogger(ExerciseApplicationTests.class);
//	String message = "BrowserStack is the intended message";

	@Test
	public void testCaseOne() throws Throwable {
		// Arrange
		logger.info(StringUtils.capitalize(Thread.currentThread().getStackTrace()[1].getMethodName()), " started");

		Vehicles datas = new Vehicles(
				new ArrayList<Vehicle>(Arrays.asList(new Vehicle("one", "ford", 1), new Vehicle("Two", "GM", 2))));

		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(datas);

		// Act
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/vehicles").accept(MediaType.APPLICATION_JSON)
				.content(json).contentType(MediaType.APPLICATION_JSON);
		ResultActions result = mockMvc.perform(requestBuilder);

		// Assert
//		MockHttpServletResponse response = result.andDo(MockMvcResultHandlers.print()).andReturn().getResponse();

		result.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk()).andReturn();
//		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
//		result.andExpect(.isCreated());
//		.andExpect(header().string("Location", "http://localhost/vehicles"));
	}

	@Test
	public void testCaseTwo() throws Throwable {
		// Arrange
		logger.info(StringUtils.capitalize(Thread.currentThread().getStackTrace()[1].getMethodName()), " started");

		// Act
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/vehicles").accept(MediaType.APPLICATION_JSON)
				.content("").contentType(MediaType.APPLICATION_JSON);
		ResultActions result = mockMvc.perform(requestBuilder);

		// Assert
//		MockHttpServletResponse response = result.andDo(MockMvcResultHandlers.print()).andReturn().getResponse();

		result.andDo(MockMvcResultHandlers.print()).andExpect(status().is5xxServerError()).andReturn();
//		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
//		result.andExpect(.isCreated());
//		.andExpect(header().string("Location", "http://localhost/vehicles"));
	}

	@Test
	public void testCaseThree() throws Throwable {
		// Arrange
		logger.info(StringUtils.capitalize(Thread.currentThread().getStackTrace()[1].getMethodName()), " started");

		Vehicles datas = new Vehicles(new ArrayList<Vehicle>());

		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(datas);

		// Act
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/vehicles").accept(MediaType.APPLICATION_JSON)
				.content(json).contentType(MediaType.APPLICATION_JSON);
		ResultActions result = mockMvc.perform(requestBuilder);

		// Assert
//		MockHttpServletResponse response = result.andDo(MockMvcResultHandlers.print()).andReturn().getResponse();

		result.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk()).andReturn();
//		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
//		result.andExpect(.isCreated());
//		.andExpect(header().string("Location", "http://localhost/vehicles"));
	}

	@Test
	public void testCaseFour() throws Throwable {
		// Arrange
		logger.info(StringUtils.capitalize(Thread.currentThread().getStackTrace()[1].getMethodName()), " started");

		Vehicle data = new Vehicle("45", "ford", null);
		Vehicles datas = new Vehicles(new ArrayList<Vehicle>(Arrays.asList(data)));

		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(datas);

		// Act
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/vehicles").accept(MediaType.APPLICATION_JSON)
				.content(json).contentType(MediaType.APPLICATION_JSON);
		ResultActions result = mockMvc.perform(requestBuilder);

		// Assert
//		MockHttpServletResponse response = result.andDo(MockMvcResultHandlers.print()).andReturn().getResponse();

		result.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk()).andReturn();
//		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
//		result.andExpect(.isCreated());
//		.andExpect(header().string("Location", "http://localhost/vehicles"));
	}

	@Test
	public void testCaseFive() throws Exception {
		// Arrange
		logger.info(StringUtils.capitalize(Thread.currentThread().getStackTrace()[1].getMethodName()), " started");

//		Vehicle data = new Vehicle("333", "ford", null);
//		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//		String json = ow.writeValueAsString(data);

		// Act
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/get").accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);
		ResultActions result = mockMvc.perform(requestBuilder);

		// Assert
		result.andExpect(status().isOk()).andReturn();

//		result.andExpect(status().isCreated())
//		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
//		result.andExpect(.isCreated());
//		.andExpect(header().string("Location", "http://localhost/vehicles"));
	}

}
