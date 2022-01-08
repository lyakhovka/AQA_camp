package api.clients;

import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class HttpSession {

    private HashMap<String, String> headers;

    private static HttpSession instance;

    private HttpSession(){
        this.headers = new HashMap<>();
    }

    public static HttpSession getInstance(){
        if (instance==null) {
            instance = new HttpSession();
        }
        return instance;
    }

    public void addHeader(String key, String value){
        this.headers.put(key, value);
    }

    public void addHeaders(HashMap<String, String> headers){
        this.headers.putAll(headers);
    }

    public HttpSession setToken(String token){
        this.addHeader("jwt", token);
        return this;
    }

    public HttpSession setExpires(String expires){
        this.addHeader("expires", expires);
        return this;
    }

    public Response get(String url){
        Response response = given()
                            .headers(this.headers)
                            .when()
                            .get(url)
                            .then()
                            .extract().response();
        return response;
    }

    public Response get(String url, Map<String, String> queryParams){
        Response response = given()
                .headers(this.headers)
                .params(queryParams)
                .when()
                .get(url)
                .then()
                .extract().response();
        return response;
    }


    public Response post(String url, String payload){
        Response response = given()
                .headers(this.headers)
                .and()
                .body(payload)
                .when()
                .post(url)
                .then()
                .extract().response();

        return response;
    }

    public Response put(String url, String payload){
        Response response = given()
                .headers(this.headers)
                .and()
                .body(payload)
                .when()
                .put(url)
                .then()
                .extract().response();

        return response;
    }

    public Response patch(String url, String payload){
        Response response=given()
                .headers(this.headers)
                .and()
                .body(payload)
                .when()
                .patch(url)
                .then()
                .extract().response();

        return response;
    }

    public Response delete(String url){
        Response response = given()
                .headers(this.headers)
                .when()
                .delete(url)
                .then()
                .extract().response();

        return response;
    }


}
