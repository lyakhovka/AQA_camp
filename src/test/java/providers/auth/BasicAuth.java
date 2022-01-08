package providers.auth;

import api.clients.HttpSession;
import config.Config;
import io.restassured.response.Response;
import models.User;

import static io.restassured.RestAssured.given;

public class BasicAuth implements Auth {

    @Override
    public HttpSession login(User user) {

        String loginUrl = Config.getInstance().getRegisteredValue("BASE_URL").toString()
        +Config.getInstance().getRegisteredValue("ENDPOINT_LOGIN").toString();

        System.out.println(loginUrl);

       Response response = given().auth()
                .preemptive()
                .basic(user.getEmail(), user.getPassword())
                .when()
                .post(loginUrl)
                .then()
                .log().ifError()
                .statusCode(200)
                .extract().response();

       String auth_token = response.path("jwt").toString();
       String expires = response.path("expires").toString();

        System.out.println(auth_token);
        System.out.println(expires);

       return HttpSession.getInstance().setToken(auth_token).setExpires(expires);

    }
}
