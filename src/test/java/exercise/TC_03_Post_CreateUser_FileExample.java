package exercise;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
//import io.restassured.internal.util.IOUtils;
import utility.Constants;

//import static io.restassured.RestAssured.*;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;


public class TC_03_Post_CreateUser_FileExample {
	
	String requestBody;
	
	@Test
	public void verifyCreateUserTest() throws Exception {
		
		
		baseURI = "https://reqres.in";
		
		//app1
		JSONObject request = new JSONObject();
		
		request.put("name", "Santhiya");
		request.put("job", "Sr. Leader");
		
		
		System.out.println("Request body: " + request.toJSONString());
		
		
		
		
		
		//app2 ---- get file 
		
		File file = new File(".\\data\\createUserRequestBody.json");
		
		if(file.exists()) {
			
			System.out.println("File Exists......");
			
			
			FileInputStream fis = new FileInputStream(file);
			requestBody = IOUtils.toString(fis, "UTF-8");
			
			//FileHandler.co
			System.out.println(requestBody);
			
		}
		
		
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
			body(requestBody).
		
		
		when().
			//action---sending a request ---get/post/put/delete etc....
			post("/api/users").
			
		
		then().	
			//validation step
			//status code
			//value
			//header
			//JSON path
			statusCode(201).
			body("name",equalTo("Subhasis")).
			//body("", equalTo("")).
			log().all();
		
		
		
	}
	
	

}
