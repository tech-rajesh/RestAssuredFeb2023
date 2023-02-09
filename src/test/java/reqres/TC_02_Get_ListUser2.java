package reqres;

import org.testng.annotations.Test;

//import static io.restassured.RestAssured.*;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TC_02_Get_ListUser2 {
	
	
	
	@Test
	public void verifyListUserTest() {
		
		
		baseURI = "https://reqres.in";
		
		
		given().
			//header
			//parameter
			//auth
			
		
		when().
			//action---sending a request ---get/post/put/delete etc....
			get("/api/users?page=2").
			
		
		then().	
			//validation step
			//status code
			//value
			//header
			//JSON path
			statusCode(200).
			body("data.email",hasItems("michael.lawson@reqres.in", "lindsay.ferguson@reqres.in")).
			log().all();
		
		
		
	}
	
	

}
