package com.employeeapi.testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC_02_GetEmployeeData extends TestBase {
	@BeforeClass
	void getemployeedata() {
		logger.info("start execution");
		RestAssured.baseURI="http://dummy.restapiexample.com/api";
		httpRequest=RestAssured.given();
		response = httpRequest.request(Method.GET,"/v1/employee/"+empid);		
	}

	@Test
	void getResponsebody() {
		String body = response.getBody().asString();
		logger.info("response body :"+body);
		Assert.assertTrue(body!=null);
	}
}
