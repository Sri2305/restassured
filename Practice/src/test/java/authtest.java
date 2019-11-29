import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class authtest {

	@Test
	public void test() throws IOException {
	RestAssured.baseURI="http://restapi.demoqa.com/authentication/CheckForAuthentication";
	
	PreemptiveBasicAuthScheme auth = new PreemptiveBasicAuthScheme();
	auth.setUserName("ToolsQA");
	auth.setPassword("TestPassword");
	RestAssured.authentication=auth;
	RequestSpecification req = RestAssured.given();
	Response res = req.request(Method.GET,"/");
	String response = res.getBody().asString();
	System.out.println(response);
	int code= res.getStatusCode();
	Assert.assertEquals(200, code);
	Headers header = res.getHeaders();
	String test = header.toString();
	for (Header header1:header) {
		System.out.println(header1.getName()+"    "+header1.getValue());
	}
	System.out.println(header);	
	FileWriter file = new FileWriter("C:\\Users\\723825\\Desktop\\Learning\\Results\\headers.txt");
    BufferedWriter bw = new BufferedWriter(file);
    bw.write(test);
    bw.close();
	}
}
