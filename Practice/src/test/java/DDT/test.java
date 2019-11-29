package DDT;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class test {
	@Test(dataProvider = "testpro")
	void test(String ename, String eage, String esalary) {
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RequestSpecification req = RestAssured.given();
		JSONObject json = new JSONObject();
		json.put("name", ename);
		json.put("age", eage);
		json.put("salary", esalary);
		req.header("Content-Type","application/json");
		req.body(json.toJSONString());
		Response res = req.request(Method.POST,"/create");
		String body = res.getBody().asString();
		System.out.println(body);
	}
	@DataProvider(name ="testpro")
	String[][]empdata()
	{
		String[][]empdata= {{"te121st","12","21"},{"dgWD","1232","6543"}};
		return(empdata);
	}

}
