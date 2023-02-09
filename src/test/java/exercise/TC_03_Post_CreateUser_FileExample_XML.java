package exercise;

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


public class TC_03_Post_CreateUser_FileExample_XML {
	
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
	public void verifyCreateUserTest2(ITestContext context) throws Exception {
		
		
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
		
		
		String result = given().
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
		extract().xmlPath().get("//*:AddResult.text()");
		
		context.setAttribute("AddResult", result);
		
	}
	
	
	@Test(priority = 2)
	public void mulTest(ITestContext context) {
		
		
		System.out.println("Get Value from Addresults" + context.getAttribute("AddResult"));
		
	}

}
