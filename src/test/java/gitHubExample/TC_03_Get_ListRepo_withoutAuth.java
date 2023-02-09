package gitHubExample;

import org.testng.annotations.Test;

import utility.Constants;

//import static io.restassured.RestAssured.*;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TC_03_Get_ListRepo_withoutAuth {
	
	
	
	@Test
	public void verifyListUserTest() {
		
		
		baseURI = "https://api.github.com";
		
		
		given().
			//header
			//parameter
			//auth
			//auth().
				//oauth2(Constants.git_token).
				//oauth2("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").
		
		when().
			//action---sending a request ---get/post/put/delete etc....
			//get("/users/"+ Constants.gitHubUser + "/repos").
			get("/users/"   + Constants.gitHubUser +     "/repos").
		
		then().	
			//validation step
			//status code
			//value
			//header
			//JSON path
			statusCode(200).
			//body("[9].full_name",equalTo("Santhiyasuja/SeleniumGrid")).
			log().all();
		
		
		
	}
	
	

}
