package mocky;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TC_01_verifyAutomationTool {
	
	
	@Test
	public void verifyRestAssuredTest() {
		
		//https://run.mocky.io/v3/55889581-da52-4383-840e-bdf6dde19252
		//https://run.mocky.io/v3/af180a34-8101-43a6-a8a1-49aec16853ee
		baseURI = "https://run.mocky.io";
		
		
		given().
			//header
			//header("Content-Type", "application/json").
			
		
		when().
			get("/v3/af180a34-8101-43a6-a8a1-49aec16853ee").
		
		then().
			statusCode(200).
			header("Content-Type", "application/xml; charset=UTF-8").
			body("courses.subject.name",hasItems("Rest Assured", "Postman", "Cypress")).
			body("courses.subject.price",hasItems("10", "6")).
			log().all();
		
		
		
		
	}

}
