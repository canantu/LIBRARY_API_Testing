package com.cydeo.utilities;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
public class ApiUtils {

    public static String generateToken(String email, String password) {


        Response response = given().accept(ContentType.JSON).config(RestAssured.config()
                        .encoderConfig(EncoderConfig.encoderConfig()
                                .encodeContentTypeAs("x-www-form-urlencoded",
                                        ContentType.URLENC)))
                .formParam("email", email)
                .formParam("password", password)
                .when()
                .get(Environment.BASE_URL + "/login")
                .then().log().all().extract().response();

        String token = response.path("token");

        String finalToken = "Bearer " + token;

        return finalToken;
    }

    public static Response loginWithCredentials(String email, String password) {


        Response response = given().accept(ContentType.JSON).config(RestAssured.config()
                        .encoderConfig(EncoderConfig.encoderConfig()
                                .encodeContentTypeAs("x-www-form-urlencoded",
                                        ContentType.URLENC)))
                .formParam("email", email)
                .formParam("password", password)
                .when().log().all()
                .post(Environment.BASE_URL + "/login")
                .then().log().all().extract().response();

        return response;
    }

    public static Response loginWithRole(String role) {

        String email, password;

        switch (role) {

            case "student":
                email = Environment.STUDENT_EMAIL;
                password = Environment.STUDENT_PASSWORD;
                break;
            case "librarian":
                email = Environment.LIBRARIAN_EMAIL;
                password = Environment.LIBRARIAN_PASSWORD;
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + role);
        }
        Response response = given().accept(ContentType.JSON).config(RestAssured.config()
                        .encoderConfig(EncoderConfig.encoderConfig()
                                .encodeContentTypeAs("x-www-form-urlencoded",
                                        ContentType.URLENC)))
                .formParam("email", email)
                .formParam("password", password)
                .when().log().all()
                .post(Environment.BASE_URL + "/login")
                .then().log().all().extract().response();

        return response;
    }

    public static String getTokenByRole(String role) {

        String email, password;

        switch (role) {

            case "student":
                email = Environment.STUDENT_EMAIL;
                password = Environment.STUDENT_PASSWORD;
                break;
            case "librarian":
                email = Environment.LIBRARIAN_EMAIL;
                password = Environment.LIBRARIAN_PASSWORD;
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + role);
        }
        Response response = given().accept(ContentType.JSON).config(RestAssured.config()
                        .encoderConfig(EncoderConfig.encoderConfig()
                                .encodeContentTypeAs("x-www-form-urlencoded",
                                        ContentType.URLENC)))
                .formParam("email", email)
                .formParam("password", password)
                .when()
                .get(Environment.BASE_URL + "/login")
                .then().log().all().extract().response();

        String token = response.path("token");

        String finalToken = "Bearer " + token;

        return finalToken;

    }
}
