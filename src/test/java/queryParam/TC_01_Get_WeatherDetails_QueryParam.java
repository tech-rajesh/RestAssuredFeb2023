package queryParam;

import org.testng.annotations.Test;

import utility.Constants;

//import static io.restassured.RestAssured.*;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TC_01_Get_WeatherDetails_QueryParam {
	
	
	
	@Test
	public void verifyWeatherTest() {
		
		
		baseURI = "http://api.openweathermap.org";
		String SearchCity = "Delhi";
		
		given().
			//header
			//parameter
			//auth
			//?q=Delhi&appid=c76e6d1f2e6af75573c66176b1ad5627
			//header("Content-Type", "").
			params("q", SearchCity).
			params("appid", Constants.apiKey).
			//params("appid", "c76e6d1f2e6af75573c66176b1ad5627").
		
		when().
			//action---sending a request ---get/post/put/delete etc....
			get("/data/2.5/weather").
			
		
		then().	
			//validation step
			//status code
			//value
			//header
			//JSON path
			statusCode(200).
			header("Server","openresty").
			header("Content-Type","application/json; charset=utf-8").
			body("weather[0].main",equalTo("Haze")).
			body("name",equalTo(SearchCity)).
			log().all();
		
		
		
	}
	
	

}
