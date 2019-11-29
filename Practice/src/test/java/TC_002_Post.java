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

public class TC_002_Post {
	@Test
	void postregister (){
		
		//specify baseuri
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		RequestSpecification httprequest = RestAssured.given();
		JSONObject params=new JSONObject();
		params.put("FirstName", "T11e11st");
		params.put("LastName", "T1111et");
		params.put("UserName", "Te11111sr");
		params.put("Password", "L1a11hm1i3");
		params.put("Email", "S11131@gmail.com");
		httprequest.header("Content-Type", "application/json");
		httprequest.body(params.toJSONString());
		Response res = httprequest.request(Method.POST,"/register");
		String response = res.getBody().asString();
		System.out.println(response);
		int status = res.getStatusCode();
		Assert.assertEquals(status,201);
		JsonPath json = res.jsonPath();
		String code = json.get("SuccessCode");
		System.out.println(code);
		Headers allheaders = res.headers();
		for(Header header:allheaders) {
			System.out.println(header.getName() + "   "+header.getName());
		}
		
		
		
	}

}
