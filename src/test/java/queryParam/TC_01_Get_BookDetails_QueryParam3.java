package queryParam;

import org.testng.annotations.Test;

import utility.Constants;

//import static io.restassured.RestAssured.*;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TC_01_Get_BookDetails_QueryParam3 {
	
	
	
	@Test
	public void verifyWeatherTest() {
		
		
		//https://demoqa.com/BookStore/v1/Book?ISBN=9781449325862
		
		baseURI = "https://demoqa.com";
		String SearchCity = "Delhi";
		
		given().
			//header
			//parameter
			//auth
			//?q=Delhi&appid=c76e6d1f2e6af75573c66176b1ad5627
			//header("Content-Type", "").
			//params("ISBN", "9781449325862").
			queryParam("ISBN", "9781449325862").
			//params("appid", "c76e6d1f2e6af75573c66176b1ad5627").
		
		when().
			//action---sending a request ---get/post/put/delete etc....
			get("/BookStore/v1/Book").
			
		
		then().	
			//validation step
			//status code
			//value
			//header
			//JSON path
			statusCode(200).
//			header("Server","openresty").
//			header("Content-Type","application/json; charset=utf-8").
//			body("weather[0].main",equalTo("Haze")).
			body("title",equalTo("Git Pocket Guide")).
			time(lessThan(2000L)).
			log().all();
		
		
		
	}
	
	

}
