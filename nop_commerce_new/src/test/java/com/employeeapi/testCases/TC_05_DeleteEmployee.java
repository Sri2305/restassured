package com.employeeapi.testCases;

import org.apache.http.HttpRequest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;

public class TC_05_DeleteEmployee extends TestBase{
	
	@Test
	void delete() {
		for(int i = 0;i<1000;i++) {
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httpRequest=RestAssured.given();
		response=httpRequest.request(Method.GET,"/employees");
		JsonPath json = response.jsonPath();
		String id = json.get("[0].id");
		System.out.println(id);
		
		response = httpRequest.request(Method.DELETE,"/delete/"+id);
		String test1 = response.getBody().asString();
		System.out.println(test1);
		logger.info(test1);
		}
	}

}
