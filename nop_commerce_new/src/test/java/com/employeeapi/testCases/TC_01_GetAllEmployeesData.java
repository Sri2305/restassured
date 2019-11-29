package com.employeeapi.testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC_01_GetAllEmployeesData extends TestBase{
	@BeforeClass
	void getAllemployess() throws InterruptedException {
		logger.info("Started first testcase");
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httpRequest=RestAssured.given();
		response = httpRequest.request(Method.GET,"/employees");
		Thread.sleep(3);
		
	}
	@Test
	void checkResponseBody() {
		logger.info("capture and check response");
		String body = response.getBody().asString();
		logger.info("Response body : "+body);
		Assert.assertTrue(body!=null);
	}

	@Test
	void checkStatusCode() {
		logger.info("capture and check statuscode");
		int code = response.getStatusCode();
		logger.info("Response code : "+code);
		Assert.assertEquals(code, 200);
	}
	@Test
	void checkResponseTime() {
		logger.info("capture and check responsetime");
		long time = response.getTime();
		logger.info("Response time : "+time);
		if(time>2000) 
			logger.warn("greater than 2000");
		Assert.assertTrue(time<20000);
	}
	@Test
	void checkStatusLine() {
		logger.info("capture and check statusline");
		String line = response.getStatusLine();
		logger.info("Response code : "+line);
		Assert.assertEquals(line, "HTTP/1.1 200 OK");
	}
}
