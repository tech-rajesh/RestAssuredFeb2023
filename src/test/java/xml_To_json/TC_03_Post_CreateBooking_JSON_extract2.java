package xml_To_json;

import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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

public class TC_03_Post_CreateBooking_JSON_extract2 {

	String requestBody;

	//@Test(dataProvider = "SampleData")
	//public void verifyCreateUserTest(String fname, String lname, ITestContext context) throws Exception {
	@Test
	public void verifyCreateUserTest( ITestContext context) throws Exception {

		baseURI = "https://restful-booker.herokuapp.com";

		// app2 ---- get file
//
//		File file = new File(".\\data\\CreateBooking.json");
//
//		if (file.exists()) {
//
//			System.out.println("File Exists......");
//
//			FileInputStream fis = new FileInputStream(file);
//			requestBody = IOUtils.toString(fis, "UTF-8");
//
//			// FileHandler.co
//			System.out.println(requestBody);
//
//		}

		String fname = "Abhishek1";
		String lname = "Yadav1";
		
		
		int org_bookingID = given().
		// header
		// parameter
		// auth
		// auth().
		// oauth2(Constants.git_token).
		// oauth2("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").
		// body(DEFAULT_AUTH).
		// header("Content-Type", "application/json").
				contentType(ContentType.JSON).
				// accept(ContentType.XML).
				body("{\r\n"
						+ "    \"firstname\" : \""+fname+"\",\r\n"
						+ "    \"lastname\" : \""+lname+"\",\r\n"
						+ "    \"totalprice\" : 111,\r\n"
						+ "    \"depositpaid\" : true,\r\n"
						+ "    \"bookingdates\" : {\r\n"
						+ "        \"checkin\" : \"2023-02-08\",\r\n"
						+ "        \"checkout\" : \"2023-02-08\"\r\n"
						+ "    },\r\n"
						+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
						+ "}").

				when().
				// action---sending a request ---get/post/put/delete etc....
				post("/booking").

				then().
				// validation step
				// status code
				// value
				// header
				// header("Content-Type", "text/xml; charset=utf-8").
				// JSON path
				statusCode(200).
				// body("name",equalTo("Subhasis")).
				// body("", equalTo("")).
				log().all().
//		and().
//			body("//*:AddResult.text()", equalTo("1110"));
				extract().jsonPath().get("bookingid");

		context.setAttribute("bookingIDCreated", org_bookingID);
	}

	@Test(priority = 1)
	public void verifyUpdateBookingTest(ITestContext context) throws Exception {

		System.out.println("Please use Booking ID for updated resource: " + context.getAttribute("bookingIDCreated"));
		
		int createdID = (int) context.getAttribute("bookingIDCreated");

		
		System.out.println("Value are: " + createdID);
		
		
		baseURI = "https://restful-booker.herokuapp.com";

		// app2 ---- get file

//		File file = new File(".\\data\\CreateBooking.json");
//
//		if (file.exists()) {
//
//			System.out.println("File Exists......");
//
//			FileInputStream fis = new FileInputStream(file);
//			requestBody = IOUtils.toString(fis, "UTF-8");
//
//			// FileHandler.co
//			System.out.println(requestBody);
//
//		}

		given().
		// header
		// parameter
		// auth
		// auth().
		// oauth2(Constants.git_token).
		// oauth2("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").
		// body(DEFAULT_AUTH).
		// header("Content-Type", "application/json").
				header("Content-Type", "application/json").
				contentType(ContentType.JSON).
				header("Accept", "application/json").
				header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=").
				// accept(ContentType.XML).
				body("{\r\n"
						+ "    \"firstname\" : \"HarishKanta\",\r\n"
						+ "    \"lastname\" : \"Kanta\",\r\n"
						+ "    \"totalprice\" : 111,\r\n"
						+ "    \"depositpaid\" : true,\r\n"
						+ "    \"bookingdates\" : {\r\n"
						+ "        \"checkin\" : \"2023-02-08\",\r\n"
						+ "        \"checkout\" : \"2023-02-08\"\r\n"
						+ "    },\r\n"
						+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
						+ "}").

				when().
				// action---sending a request ---get/post/put/delete etc....
					put("/booking/"+ createdID).

				then().
				// validation step
				// status code
				// value
				// header
				// header("Content-Type", "text/xml; charset=utf-8").
				// JSON path
				//statusCode(200).
				// body("name",equalTo("Subhasis")).
				// body("", equalTo("")).
				log().all();

	}
	
	
	@BeforeMethod
	public void delayInEachIteration() throws InterruptedException {
		
		Thread.sleep(3000);
		System.out.println("======================================================================");
		System.out.println("======================================================================");
		
	}
	
	
	@DataProvider
	public Object[][] SampleData() {
		
		Object[][] data = {{"Subasis", "Mohanty"}, {"Srinivas", "Reddy Naini"}, {"Sridevi", "Bavisetti"}};
		return data;
	}

}
