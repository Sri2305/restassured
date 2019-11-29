package com.employeeapi.testCases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;
import com.employeeapi.utilities.RestUtils;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;

public class TC_03_CreateNewEmployee extends TestBase{
    
	String empname = RestUtils.empname();
	String empage = RestUtils.empage();
	String empsal = RestUtils.empsal();
	
	@BeforeClass
	
	public void createemployee() {
    	 
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httpRequest=RestAssured.given();
		JSONObject params = new JSONObject();
		params.put("name", empname);
		params.put("age", empage);
		params.put("salary", empsal);
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(params.toJSONString());
		response = httpRequest.request(Method.POST,"/create");
		
			
     }
	
	@Test
	public void captureid() {
		JsonPath json = response.jsonPath();
		String id = json.get("id");
		System.out.println(id);
	}
	
	@Test
	void responsebody() {
		 String body = response.getBody().asString();
		 logger.info(body);
		Assert.assertTrue(body!=null);
		Assert.assertEquals(body.contains(empname), true);
		Assert.assertEquals(body.contains(empage), true);
		Assert.assertEquals(body.contains(empsal), true);
	}
	
	@Test
	void captureHeaders() {
		
		Headers header = response.getHeaders();
		
		for (Header h1:header) {
			logger.info(h1);
		}
	}
	
	@AfterTest
	void endlog() {
		logger.info("end linesss");
		
	}
	
}
