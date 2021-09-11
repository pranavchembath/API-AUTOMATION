
/*
 * This class consists of the re-usable componenets using within this Project
 * 
 * 
 * @author Pranav Chembath
 * @version 1.0
 */

package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils {

	public static RequestSpecification req;
	ResponseSpecification resspec;
	
	// Creating global request specification which can be used all place in this module. Common query parameters and headers can be set in this method.
	public RequestSpecification requestSpecification() throws IOException {

		if(req ==null) {

			PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
			req = new RequestSpecBuilder().setContentType(ContentType.JSON)
					.setBaseUri(getGlobalValue("baseUrl"))
					.addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log))
					.build();
			return req;

		}return req;

	}
	
	// Creating global Response Specification which can be used all place in this module. Common query parameters and headers can be set in this method.
	public ResponseSpecification responseSpecification() {
		resspec = new ResponseSpecBuilder()
				.expectContentType(ContentType.JSON)
				.build();
		return resspec;
	}

	//Getting Global Parameter variable values
	public static String getGlobalValue(String key) throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\MyLap\\eclipse-workspace\\SurePay-Assignment\\SurePayAssignment\\src\\test\\java\\resources\\global.properties");
		prop.load(fis);
		return prop.getProperty(key);

	}
	
	// Get Response Key value from Json Response
	public String getJsonPathString(Response response, String key) {
		String resp = response.asString();
		JsonPath js =  new JsonPath(resp);
		return  js.get(key).toString();
	}

}
