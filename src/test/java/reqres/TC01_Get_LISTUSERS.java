package reqres;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utility.ReadDatFromConfigFile;

public class TC01_Get_LISTUSERS {

	
	
	@Test
	public void verify_ListUserTest() throws Exception {
		
		ReadDatFromConfigFile conf = new ReadDatFromConfigFile();
		conf.getBaseURL_QA();
		
		System.out.println(conf.getBaseURL_QA());
		//environment
		RestAssured.baseURI = "https://reqres.in";
		
		Response resp = RestAssured.get("/api/users?page=2");
		
		
		
		
		
		System.out.println("Status Code: " + resp.getStatusCode());  					//status code ---- 200
		System.out.println("ResponseTime: " + resp.getTime());							//responseTime
		
		
		int actualStatusCode = resp.getStatusCode();
		
		//validation step
		//validate Status Code --- 200
		
		Assert.assertTrue(true);
		Assert.assertEquals(actualStatusCode, 200);
		
	}
	
	
	
	

}
