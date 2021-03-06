package tests.api;

import config.Config;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import testSuits.categories.P1Tests;


public class TestConfig {

    @Category(P1Tests.class)
    @Test
    public void testConfig() {

        // This test prints out the values of registered properties.
        // The test output depends on TARGET you have exported before the test.
        // Expected TARGET values are TARGET=prod, TARGET=stage.

        System.out.println("TEST TARGET: " + System.getenv().get("TARGET"));

        System.out.println("LOGIN_PAGE_HEADER: " + Config.getInstance().getRegisteredValue("LOGIN_PAGE_HEADER"));
        System.out.println("PATH: " + Config.getInstance().getRegisteredValue("PATH"));
        System.out.println("SOMETHING: " + Config.getInstance().getRegisteredValue("SOMETHING"));

    }
}

