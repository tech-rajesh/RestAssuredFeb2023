package openWeather;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class TC02_GetWeatherDetails {

	
	
	@Test
	public void verifyWeatherTest() {
		
//		get("http://api.openweathermap.org/data/2.5/weather?q=Delhi&appid=c76e6d1f2e6af75573c66176b1ad5627");
//		
//		
//		given();
		
		
		given().
		//setup/forming a request
		
		when().
		//action/sending a request
		
		then()
		//validation steps
		;
		
//		System.out.println("Status Code: " + resp.getStatusCode());  					//status code ---- 200
//		System.out.println("ResponseTime: " + resp.getTime());							//responseTime
//		
//		
//		int actualStatusCode = resp.getStatusCode();
//		
//		//validation step
//		//validate Status Code --- 200
//		
//		Assert.assertTrue(true);
		assertEquals(201, 201);
		
	}
	
	
	
	

}
