package tests.api;

import api.clients.WebApiClient;
import config.Config;
import models.User;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import providers.auth.Auth;
import providers.auth.BasicAuth;
import testSuits.categories.P1Tests;
import testSuits.categories.P2Tests;

public class TestWebApiBasicAuth {

    public static WebApiClient webApi;

    //Why not to use just usual constructor instead of @BeforeClass annotation?

    @BeforeClass
    public static void BasicAuthSessionSetUp() {
        Auth auth = new BasicAuth();
        User user = new User(Config.getInstance().getRegisteredValue("EMAIL"), Config.getInstance().getRegisteredValue("PASSWORD"));
        webApi = new WebApiClient(auth.login(user));
    }

    @Category(P2Tests.class)
    @Test
    public void test_webApi_can_return_something() {
    //this test just verifies WebApiClient viability

        System.out.println("DASHBOARD ITEMS: " + webApi.getDashboardItems().getBody().asString());
    }

    @Category({P1Tests.class, P2Tests.class})
    @Test
    public void test_getDashboardItems_respond_200() {
        Assert.assertEquals(200, webApi.getDashboardItems().getStatusCode());
    }

    @AfterClass
    public static void tearDown(){
        webApi.logout();
    }
}
