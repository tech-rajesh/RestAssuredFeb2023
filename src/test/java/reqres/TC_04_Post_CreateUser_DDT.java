package reqres;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import utility.Constants;

//import static io.restassured.RestAssured.*;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class TC_04_Post_CreateUser_DDT {

	@Test(dataProvider = "smokeTestData")
	public void verifyCreateUserTest(String e_name, String e_role) {

		
		System.out.println("Name: " + e_name);
		System.out.println("ROLE: " + e_role);
		
		baseURI = "https://reqres.in";


		JSONObject request = new JSONObject();

		request.put("name", e_name);
		request.put("job", e_role);

		System.out.println("Request body: " + request.toJSONString());

		given().
		// header
		// parameter
		// auth
		// auth().
		// oauth2(Constants.git_token).
		// oauth2("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").
		// body(DEFAULT_AUTH).
				header("Content-Type", "application/json").
				contentType(ContentType.JSON).
				body(request.toJSONString()).

				when().
				// action---sending a request ---get/post/put/delete etc....
					post("/api/users").

				then().
				// validation step
				// status code
				// value
				// header
				// JSON path
					statusCode(201).
					body("name", equalTo(e_name)).
					body("job", equalTo(e_role)).
				// body("", equalTo("")).
					log().all();

	}
	
	
	@DataProvider
	public Object [] [] smokeTestData() {
		
		
		Object [][] data = { {"Abhay","Sr. Leader"}, {"Amit","Leader"}, {"Nithya","Srm Manager"}};
		return data;
		
		
	}

}
