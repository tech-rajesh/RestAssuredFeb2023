package openWeather;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TC01_GetWeatherDetails {

	
	
	@Test
	public void verifyWeatherTest() {
		
		Response resp = RestAssured.get("http://api.openweathermap.org/data/2.5/weather?q=Delhi&appid=c76e6d1f2e6af75573c66176b1ad5627");
		
		
		
		
		
		System.out.println("Status Code: " + resp.getStatusCode());  					//status code ---- 200
		System.out.println("ResponseTime: " + resp.getTime());							//responseTime
		
		
		int actualStatusCode = resp.getStatusCode();
		
		//validation step
		//validate Status Code --- 200
		
		Assert.assertTrue(true);
		Assert.assertEquals(actualStatusCode, 201);
		
		
		
		//ResponseTime ------- 
		//NFR ------ response time should be less than 5000 msec
		
		
	}
	
	
	
	

}
