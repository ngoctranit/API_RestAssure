package api_document;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dataTest.Login;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Post_Login {
	Login login;

	@BeforeClass
	public void Before_Class() {
		login = new Login();
	}

	@Test
	public void Post_Login() {
		RestAssured.baseURI = "https://www.hogodoc.com/";
		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("EmailAddress", "tuyetphong001@gmail.com");
		requestParams.put("Password", "e10adc3949ba59abbe56e057f20f883e");
		request.body(requestParams.toJSONString());
		Response response = request.post("/HoGo/api/v1/Login");
		ResponseBody body = response.getBody();
		System.out.println(response.getStatusLine());
		System.out.println(body.asString());
	}

	// @Test
	public void GetWeatherDetails() {
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "https://www.hogodoc.com/";

		// Get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		RequestSpecification httpRequest = RestAssured.given();

		// Make a GET request call directly by using RequestSpecification.get() method.
		// Make sure you specify the resource name.
		Response response = httpRequest.get("/Hyderabad");

		// Response.asString method will directly return the content of the body
		// as String.
		System.out.println("Response Body is =>  " + response.asString());
	}
}
