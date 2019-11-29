package DDT;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion.User;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class xceltest {
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
	String[][]empdata() throws IOException
	{
		String path = System.getProperty("user.dir")+"\\src\\test\\java\\DDT\\sample.xlsx";
		int rowcount=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
		String[][]empdata = new String[rowcount][colcount];
		for(int i=1;i<=rowcount;i++) {
			for(int j=0;j<colcount;j++) {
				empdata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		
		
		//String[][]empdata= {{"te121st","12","21"},{"dgWD","1232","6543"}};
		return(empdata);
		
	}

}
