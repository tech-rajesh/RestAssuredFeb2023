package openWeather;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class TC_03_getWeatherDetails_Header {
	
	//remove unused import/import// ctrl+shift+O
	
	@Test
	public void verifyWeatherAPITest() {
		
		
		Response response = RestAssured.get("http://api.openweathermap.org/data/2.5/weather?q=Delhi&appid=c76e6d1f2e6af75573c66176b1ad5627");
		
		
		
		//Header - specific header
		String ActualContentTypeHeader = response.header("Content-Type");
		System.out.println("Content Type Header: " + ActualContentTypeHeader);
		Assert.assertEquals(ActualContentTypeHeader, "application/json; charset=utf-8");
		
		//Headers
		Headers allHeader = response.headers();
		
		//Interate over all headers
		
		for(Header header : allHeader) {
			
			System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
			
			
		}
		
		
		
	}
	

}
