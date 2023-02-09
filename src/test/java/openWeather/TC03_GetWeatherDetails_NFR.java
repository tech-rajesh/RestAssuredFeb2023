package openWeather;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TC03_GetWeatherDetails_NFR {

	
	
	@Test
	public void verifyWeatherTest() {
		
		Response resp = RestAssured.get("http://api.openweathermap.org/data/2.5/weather?q=Delhi&appid=c76e6d1f2e6af75573c66176b1ad5627");
		
		
		
		
		
		System.out.println("Status Code: " + resp.getStatusCode());  					//status code ---- 200
		System.out.println("ResponseTime: " + resp.getTime());							//responseTime
		
		
		int actualStatusCode = resp.getStatusCode();
		long actualResponseTime = resp.getTime();										//905msec
		//validation step
		//validate Status Code --- 200
		
		Assert.assertTrue(true);
		Assert.assertEquals(actualStatusCode, 200, "error message");
		
		
		
		//ResponseTime ------- 
		//NFR ------ response time should be less than 5000 msec
		
		//1200 < 1205
		
		if(actualResponseTime < 5000 ) {
			
			System.out.println("Test Passed..." + actualResponseTime);
			Assert.assertTrue(true);
			
		}
		else {
			System.out.println("Test failed..." + actualResponseTime);
			System.out.println("error message.....");
			Assert.assertTrue(false);
		}
		
		//Assert.assertTrue(actualResponseTime);)
		
	}
	
	
	
	

}
