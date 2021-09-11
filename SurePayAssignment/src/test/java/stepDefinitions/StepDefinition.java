/*
 * StepDefinition class consists of test scripts/ steps for each Features. 
 *
 * 
 * 
 * @author Pranav Chembath
 * @version 1.0
 */

package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.JsonArray;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.common.mapper.TypeRef;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.Comments;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class StepDefinition extends Utils {

	Response response;
	JsonPath js;
	int sizeofArray;
	ResponseSpecification resspec;
	RequestSpecification req;
	RequestSpecification reqspec;
	Iterator itr;
	String strResponse;
	private static boolean Flag = false;
	JsonArray jsonArray = new JsonArray();
	String emailaddress;
	int expectedValue;
	int actualValue;
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

	TestDataBuild data = new TestDataBuild();

	List<Comments> commentsResponse = new ArrayList<Comments>();

	@Given("todos resource")
	public void todos_resource() throws IOException {

		reqspec = given().spec(requestSpecification());

	}

	@Then("the API call is success with status code {int}")
	public void the_api_call_is_success_with_status_code(Integer int1) {
		expectedValue = int1;
		assertEquals(response.getStatusCode(), expectedValue);
	}

	@Then("Print all unique existing users in console")
	public void print_all_unique_existing_users_in_console() {
		strResponse = response.asString();
		js = new JsonPath(strResponse);
		sizeofArray = js.getList("$").size();

		List<String> userids = Arrays.asList(js.getString("userId").split("\\s*,\\s*"));
		Set<String> unique_userids = new HashSet<String>(userids);

		itr = unique_userids.iterator();

		System.out.println("Below are the list of unique user ids: ");

		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

	@Given("comments resource with userId {int}")
	public void comments_resource_with_user_id(Integer int1) throws IOException {
		reqspec = given().spec(requestSpecification()).queryParam("userId", int1);
	}

	@When("user calls validateEmail with Get http request")
	public void user_calls_validate_email_with_get_http_request() {

		response = reqspec.when().get("/comments").then().spec(responseSpecification()).log().all().extract()
				.response();

	}

	@Then("Validate the email address format")
	public void validate_the_email_address_format() {

		List<Comments> comments = response.getBody().as(new TypeRef<List<Comments>>() {
		});

		for (Comments comment : comments) {
			Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(((Comments) comment).getEmail());
			assertTrue(matcher.find());
		}
	}

	@Then("Print the status in console")
	public void print_the_status_in_console() {
		if (Flag) {
			System.out.println("All emails are in the Proper Format");
		} else {
			System.out.println("All emails are not in the Proper Format");
		}
	}

	@Given("posts payload with {string} {string} {string}")
	public void posts_payload_with(String title, String userid, String body) throws IOException {

		reqspec = given().log().all().spec(requestSpecification()).queryParam("Charset", "UTF-8")
				.body(data.postsbyUser(title, body, userid));

	}


	@Then("Validate key {string} with value as {int}")
	public void validate_key_with_value_as(String key, int expectedValue) {
		assertEquals(Integer.parseInt(getJsonPathString(response, key)), expectedValue);

	}

	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method) {

		// Constructor will be called with value of resource which you pass through it.
		APIResources resourceAPI = APIResources.valueOf(resource);

		if (method.equalsIgnoreCase("POST")) {
			response = reqspec.when().post(resourceAPI.getResource()).then().spec(responseSpecification()).log().all()
					.extract().response();
		} else if (method.equalsIgnoreCase("GET")) {

			response = reqspec.when().get(resourceAPI.getResource()).then().spec(responseSpecification()).log().all()
					.extract().response();
		}
	}

}
