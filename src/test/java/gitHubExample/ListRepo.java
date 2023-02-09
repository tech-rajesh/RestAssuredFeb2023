package gitHubExample;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import utility.Constants;

public class ListRepo {

	public static void main(String[] args) {

		baseURI = "https://api.github.com";

		given().
		// header
		// parameter
		// auth
				auth().
					//oauth2(Constants.git_token).
					oauth2("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").

				when().
				// action---sending a request ---get/post/put/delete etc....
				get("/user/repos").

				then().
				// validation step
				// status code
				// value
				// header
				// JSON path
				statusCode(200).
				body("[0].full_name", equalTo("Santhiyasuja/SeleniumGrid")).log().all();

	}

}
