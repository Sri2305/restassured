import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC_007_Authentication {
@Test
	public void Authentication() {
		RestAssured.baseURI="http://restapi.demoqa.com/authentication/CheckForAuthentication";
		PreemptiveBasicAuthScheme authscheme = new PreemptiveBasicAuthScheme();
		authscheme.setUserName("ToolsQA");
		authscheme.setPassword("TestPassword");
		RestAssured.authentication=authscheme;
		RequestSpecification req = RestAssured.given();
		Response res = req.request(Method.GET,"/");
		String body = res.getBody().asString();
		System.out.println(body);
		int statuscode=res.getStatusCode();
		Assert.assertEquals(200, statuscode);
		
	}
}
