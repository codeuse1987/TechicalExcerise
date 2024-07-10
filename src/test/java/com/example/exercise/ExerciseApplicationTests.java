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
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.transaction.annotation.Transactional;

import com.example.exercise.enity.Vehicle;
import com.example.exercise.model.Vehicles;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class ExerciseApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	private static Logger logger = LoggerFactory.getLogger(ExerciseApplicationTests.class);
//	String message = "BrowserStack is the intended message";

	@Test
	@Rollback
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
	@Rollback
	public void testCaseTwo() throws Throwable {
		// Arrange
		logger.info(StringUtils.capitalize(Thread.currentThread().getStackTrace()[1].getMethodName()), " started");

		// Act
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/vehicles").accept(MediaType.APPLICATION_JSON)
				.content("").contentType(MediaType.APPLICATION_JSON);
		ResultActions result = mockMvc.perform(requestBuilder);

		// Assert
//		MockHttpServletResponse response = result.andDo(MockMvcResultHandlers.print()).andReturn().getResponse();

		result.andDo(MockMvcResultHandlers.print()).andExpect(status().isBadRequest()).andReturn();
//		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
//		result.andExpect(.isCreated());
//		.andExpect(header().string("Location", "http://localhost/vehicles"));
	}

	@Test
	@Rollback
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
	@Rollback
	public void testCaseFour() throws Throwable {
		// Arrange
		logger.info(StringUtils.capitalize(Thread.currentThread().getStackTrace()[1].getMethodName()), " started");

		Vehicle data = new Vehicle("01", "ford", 2);
		Vehicles datas = new Vehicles(new ArrayList<Vehicle>(Arrays.asList(data)));

		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(datas);

		// Act
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/vehicles").accept(MediaType.APPLICATION_JSON)
				.content(json).contentType(MediaType.APPLICATION_JSON);
		ResultActions result = mockMvc.perform(requestBuilder);

		// Assert
//		MockHttpServletResponse response = result.andDo(MockMvcResultHandlers.print()).andReturn().getResponse();

		result.andDo(MockMvcResultHandlers.print()).andExpect(status().isBadRequest()).andReturn();
//		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
//		result.andExpect(.isCreated());
//		.andExpect(header().string("Location", "http://localhost/vehicles"));
	}

	@Test
	@Rollback
	public void testCaseFive() throws Exception {

		logger.info(StringUtils.capitalize(Thread.currentThread().getStackTrace()[1].getMethodName()), " started");

		// Arrange

		Vehicle data = new Vehicle("Three", "ford", null);
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
	}

	@Test
	@Rollback
	public void testCaseSix() throws Exception {

		logger.info(StringUtils.capitalize(Thread.currentThread().getStackTrace()[1].getMethodName()), " started");

		// Arrange

		Vehicle data = new Vehicle(null, "ford", 2);
		Vehicles datas = new Vehicles(new ArrayList<Vehicle>(Arrays.asList(data)));

		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(datas);

		// Act
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/vehicles").accept(MediaType.APPLICATION_JSON)
				.content(json).contentType(MediaType.APPLICATION_JSON);
		ResultActions result = mockMvc.perform(requestBuilder);

		// Assert
//		MockHttpServletResponse response = result.andDo(MockMvcResultHandlers.print()).andReturn().getResponse();

		result.andDo(MockMvcResultHandlers.print()).andExpect(status().isBadRequest()).andReturn();
	}

	@Test
	@Rollback
	public void testCaseSeven() throws Exception {

		logger.info(StringUtils.capitalize(Thread.currentThread().getStackTrace()[1].getMethodName()), " started");

		// Arrange

		Vehicle data = new Vehicle("Four", null, 2);
		Vehicles datas = new Vehicles(new ArrayList<Vehicle>(Arrays.asList(data)));

		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(datas);

		// Act
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/vehicles").accept(MediaType.APPLICATION_JSON)
				.content(json).contentType(MediaType.APPLICATION_JSON);
		ResultActions result = mockMvc.perform(requestBuilder);

		// Assert
//		MockHttpServletResponse response = result.andDo(MockMvcResultHandlers.print()).andReturn().getResponse();

		result.andDo(MockMvcResultHandlers.print()).andExpect(status().isBadRequest()).andReturn();
	}

	@Test
	@Rollback
	public void testCaseEight() throws Exception {

		logger.info(StringUtils.capitalize(Thread.currentThread().getStackTrace()[1].getMethodName()), " started");

		// Arrange

		Vehicle data = new Vehicle("Four", "VW", 2);
		Vehicles datas = new Vehicles(new ArrayList<Vehicle>(Arrays.asList(data)));

		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(datas);

		// Act
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/vehicles").accept(MediaType.APPLICATION_JSON)
				.content(json).contentType(MediaType.APPLICATION_JSON);
		ResultActions result = mockMvc.perform(requestBuilder);

		// Assert
//		MockHttpServletResponse response = result.andDo(MockMvcResultHandlers.print()).and 
		result.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk()).andReturn();
	}

	@Test
	@Rollback
	public void testCaseNine() throws Exception {

		logger.info(StringUtils.capitalize(Thread.currentThread().getStackTrace()[1].getMethodName()), " started");

		// Arrange

		Vehicle data = new Vehicle("999", "Ford", 1003);
		Vehicles datas = new Vehicles(new ArrayList<Vehicle>(Arrays.asList(data)));

		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(datas);

		// Act
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/vehicles").accept(MediaType.APPLICATION_JSON)
				.content(json).contentType(MediaType.APPLICATION_JSON);
		ResultActions result = mockMvc.perform(requestBuilder);

		// Assert
//		MockHttpServletResponse response = result.andDo(MockMvcResultHandlers.print()).and 
		result.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk()).andReturn();
	}

	@Test
	@Rollback
	public void testCaseTen() throws Exception {

		logger.info(StringUtils.capitalize(Thread.currentThread().getStackTrace()[1].getMethodName()), " started");

		// Arrange

		Vehicle data = new Vehicle("997", "Ford", 2);
		Vehicles datas = new Vehicles(new ArrayList<Vehicle>(Arrays.asList(data)));

		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(datas);

		// Act
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/vehicles").accept(MediaType.APPLICATION_JSON)
				.content(json).contentType(MediaType.APPLICATION_JSON);
		ResultActions result = mockMvc.perform(requestBuilder);

		// Assert
		result.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk()).andReturn();
	}

	@Test
	@Rollback
	public void testCaseEleven() throws Exception {

		logger.info(StringUtils.capitalize(Thread.currentThread().getStackTrace()[1].getMethodName()), " started");

		// Arrange
		Vehicles datas = new Vehicles(
				new ArrayList<Vehicle>(Arrays.asList(new Vehicle("five", "Ford", 1001), new Vehicle("six", "GM", 2))));

		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(datas);

		// Act
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/vehicles").accept(MediaType.APPLICATION_JSON)
				.content(json).contentType(MediaType.APPLICATION_JSON);
		ResultActions result = mockMvc.perform(requestBuilder);

		// Assert
		result.andDo(MockMvcResultHandlers.print()).andExpect(status().isBadRequest()).andReturn();
	}

	@Test
	@Rollback
	public void testCaseTwelve() throws Exception {

		logger.info(StringUtils.capitalize(Thread.currentThread().getStackTrace()[1].getMethodName()), " started");

		// Arrange
		Vehicles datas = new Vehicles(
				new ArrayList<Vehicle>(Arrays.asList(new Vehicle("five", "Ford", 2), new Vehicle("six", "GM", 1002))));

		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(datas);

		// Act
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/vehicles").accept(MediaType.APPLICATION_JSON)
				.content(json).contentType(MediaType.APPLICATION_JSON);
		ResultActions result = mockMvc.perform(requestBuilder);

		// Assert
		result.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk()).andReturn();
	}
}

