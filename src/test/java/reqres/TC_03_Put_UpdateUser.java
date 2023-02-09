package reqres;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import utility.Constants;

//import static io.restassured.RestAssured.*;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class TC_03_Put_UpdateUser {
	
	
	
	@Test
	public void verifyUpdateUserTest() {
		
		
		baseURI = "https://reqres.in";
		
		
		JSONObject request = new JSONObject();
		
		request.put("name", "Santhiya");
		request.put("job", "Sr. Leader");
		
		
		System.out.println("Request body: " + request.toJSONString());
		
		given().
			//header
			//parameter
			//auth
			//auth().
				//oauth2(Constants.git_token).
				//oauth2("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").
			//body(DEFAULT_AUTH).
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			body(request.toJSONString()).
		
		
		when().
			//action---sending a request ---get/post/put/delete etc....
			put("/api/users/2").
			
		
		then().	
			//validation step
			//status code
			//value
			//header
			header("Content-Type", "application/json; charset=utf-8").
			header("Transfer-Encoding", "chunked").
			header("X-Powered-By", "Express").
			//JSON path
			statusCode(200).
			body("name",equalTo("Santhiya")).
			//body("", equalTo("")).
			log().all();
		
		
		
	}
	
	

}
