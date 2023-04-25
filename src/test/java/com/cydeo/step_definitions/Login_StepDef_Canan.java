package com.cydeo.step_definitions;
import com.cydeo.pages.Home_Page_Canan;
import com.cydeo.pages.Login_Page_Canan;
import com.cydeo.utilities.ApiUtils;
import com.cydeo.utilities.Environment;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class Login_StepDef_Canan {

    String token;
    Response response;
    @Given("I send a request to the login endpoint as {string} using valid credentials")
    public void i_send_a_request_to_the_login_endpoint_as_using_valid_credentials(String role) {
         response = ApiUtils.loginWithRole(role);
    }


    @Then("The status code should be {string}")
    public void the_status_code_should_be(String expectedStatusCode) {
        Assert.assertEquals(Integer.parseInt(expectedStatusCode), response.statusCode());
    }

    @Then("API returns a valid authentication token")
    public void api_returns_a_valid_authentication_token() {
         token = response.jsonPath().getString("token");
        Assert.assertFalse(token.isEmpty());
    }

    @Then("I receive error message {string}")
    public void i_receive_error_message(String expectedError) {
        String actualError = response.jsonPath().getString("error");
        Assert.assertEquals(expectedError, actualError);
    }

    @Given("I send a request to the login endpoint as {string} using invalid credentials")
    public void i_send_a_request_to_the_login_endpoint_as_using_invalid_credentials(String role) {
        String email, password;
        switch (role) {
            case "student":
                email = Environment.STUDENT_EMAIL;
                password = "invalid";
                break;
            case "librarian":
                email = Environment.LIBRARIAN_EMAIL;
                password = "invalid";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + role);
        }
        response = ApiUtils.loginWithCredentials(email, password);
    }

}
