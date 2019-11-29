import static org.testng.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class tets {
 @Test
	public void test() {
	 RestAssured.baseURI="http://restapi.demoqa.com/customer";
	 RequestSpecification req = RestAssured.given();
	 JSONObject params = new JSONObject();
	 params.put("FirstName", "t2111");
	 params.put("LastName", "1s121");
		params.put("UserName", "2111q");
		params.put("Password", "1121r");
		params.put("Email", "a1b121@gmail.com");
		req.header("Content-Type", "application/json");
		req.body(params.toJSONString());
		Response res = req.request(Method.POST,"/register");
	String body = res.getBody().asString();
	System.out.println(body);
	int code = res.getStatusCode();
	Assert.assertEquals(code, 201);
	JsonPath json = res.jsonPath();
	String test1 = json.get("SuccessCode");
	System.out.println(test1);
	
	Assert.assertEquals(body.contains("OPERATION_SUCCESS"), true);
	Headers allHeaders = res.getHeaders();
	for (Header header:allHeaders) {
		System.out.println(header.getName() + "is equals to" + header.getValue());
	}
		
 }
}
