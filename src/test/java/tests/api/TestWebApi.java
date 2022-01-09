package tests.api;

import api.clients.WebApiClient;
import config.Config;
import models.User;
import org.junit.Test;
import providers.auth.Auth;
import providers.auth.BasicAuth;

public class TestWebApi {

    User user = new User(Config.getInstance().getRegisteredValue("EMAIL"), Config.getInstance().getRegisteredValue("PASSWORD"));
    Auth auth = new BasicAuth();
    WebApiClient webApi = new WebApiClient(auth.login(user));

    @Test
    public void testWebApi() {
//this test just verifies WebApiClient viability

        System.out.println("DASHBOARD ITEMS: " + webApi.getDashboardItems().getBody().asString());
    }

}
