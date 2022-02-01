package testSuits;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.api.TestConfig;
import tests.api.TestWebApiBasicAuth;
import testSuits.categories.P1Tests;

@RunWith(Categories.class)
@Categories.IncludeCategory(P1Tests.class)
@Suite.SuiteClasses({TestConfig.class, TestWebApiBasicAuth.class})
public class P1TestsSuite{
}
