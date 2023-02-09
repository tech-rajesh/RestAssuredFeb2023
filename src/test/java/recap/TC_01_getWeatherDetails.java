package recap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class TC_01_getWeatherDetails {
	
	//remove unused import/import// ctrl+shift+O
	
	@Test
	public void verifyWeatherAPITest() {
		
		
		Response response = RestAssured.get("http://api.openweathermap.org/data/2.5/weather?q=Delhi&appid=c76e6d1f2e6af75573c66176b1ad5627");
		
		
		int actualStatusCode = response.getStatusCode();
		
		ResponseBody body = response.getBody();
		
		
		
		System.out.println("Status Code: " + actualStatusCode);
		System.out.println("-------------Response Body-------------- " );
		//By ResponseBody.asString , we can convert the body into string resp
		
		//body.asString();
		System.out.println(body);
		System.out.println("--------------------------- " );
		System.out.println(body.asString());
		
		System.out.println("====================================" );
		System.out.println(body.asPrettyString());
		
		//validation step ----- 200
		Assert.assertEquals(actualStatusCode, 200, "Validation of Weather API status code get failed.");
		
		
		//
		Assert.assertTrue(body.asString().toLowerCase().contains("delhi"));
		
		
	}
	

}
