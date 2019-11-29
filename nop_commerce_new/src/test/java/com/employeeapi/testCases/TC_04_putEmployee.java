package com.employeeapi.testCases;

import org.apache.http.protocol.HTTP;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;
import com.employeeapi.utilities.RestUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC_04_putEmployee extends TestBase  {

	String empname = RestUtils.empname();
	String empage = RestUtils.empage();
	String empsal = RestUtils.empsal();
	
	
	@BeforeTest
	void updateEmployee() {
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
	    httpRequest = RestAssured.given();
	    JSONObject testparams = new JSONObject();
	    testparams.put("name", empname);
	    testparams.put("age", empage);
	    testparams.put("salary", empsal);
	    httpRequest.header("content-Type","application/json");
	    httpRequest.body(testparams.toJSONString());
	    response = httpRequest.request(Method.PUT,"/update"+empid);
	
	}
	@Test
	 void verifyResponsebody () {
		String body = response.getBody().asString();
		logger.info(body);
		System.out.println(body);
	}
	
}
