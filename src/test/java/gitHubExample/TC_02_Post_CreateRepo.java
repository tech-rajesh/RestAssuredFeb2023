package gitHubExample;

import org.testng.annotations.Test;

import utility.Constants;

//import static io.restassured.RestAssured.*;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class TC_02_Post_CreateRepo {
	
	
	
	@Test
	public void verifyListUserTest() {
		
		
		String repoName = "RestAPIAutomation_20230203";
		
		baseURI = "https://api.github.com";
		
		
		//Request Body
		//
		JSONObject request = new JSONObject();
		request.putIfAbsent("name", repoName);
		
		
		given().
			//header
			//parameter
			//auth
			auth().
				oauth2(Constants.git_token).
				//oauth2("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").
		
		when().
			//action---sending a request ---get/post/put/delete etc....
			post("/user/repos").
			
		
		then().	
			//validation step
			//status code
			//value
			//header
			//JSON path
			statusCode(201).
			//body("name",equalTo(repoName)).
			log().all();
		
		
		
	}
	
	

}
