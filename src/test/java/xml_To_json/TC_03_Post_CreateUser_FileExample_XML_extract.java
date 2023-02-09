package xml_To_json;

import org.testng.ITestContext;
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


public class TC_03_Post_CreateUser_FileExample_XML_extract {
	
	String requestBody;
	
	@Test
	public void verifyCreateUserTest() throws Exception {
		
		
		baseURI = "http://dneonline.com/";
		
		
		//app2 ---- get file 
		
		File file = new File(".\\data\\AddRequestBody.xml");
		
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
			//header("Content-Type", "application/json").
			contentType("text/xml").
			accept(ContentType.XML).
			body(requestBody).
		
		
		when().
			//action---sending a request ---get/post/put/delete etc....
			post("/calculator.asmx").
			
		
		then().	
			//validation step
			//status code
			//value
			//header
			header("Content-Type", "text/xml; charset=utf-8").
			//JSON path
			statusCode(200).
			//body("name",equalTo("Subhasis")).
			//body("", equalTo("")).
			log().all().
		and().
			body("//*:AddResult.text()", equalTo("1110"));
		
		
		
	}
	
	
	@Test
	public void verifyCreateUserTest2() throws Exception {
		
		
		baseURI = "http://dneonline.com/";
		
		
		//app2 ---- get file 
		
		File file = new File(".\\data\\AddRequestBody.xml");
		
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
			//header("Content-Type", "application/json").
			contentType("text/xml").
			accept(ContentType.XML).
			body(requestBody).
		
		
		when().
			//action---sending a request ---get/post/put/delete etc....
			post("/calculator.asmx").
			
		
		then().	
			//validation step
			//status code
			//value
			//header
			header("Content-Type", "text/xml; charset=utf-8").
			//JSON path
			statusCode(200).
			//body("name",equalTo("Subhasis")).
			//body("", equalTo("")).
			log().all();
		
		
		
	}
	
	
	

}
