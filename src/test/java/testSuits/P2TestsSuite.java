package testSuits;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import testSuits.categories.P2Tests;
import tests.api.TestConfig;
import tests.api.TestWebApiBasicAuth;

@RunWith(Categories.class)
@Categories.IncludeCategory(P2Tests.class)
@Suite.SuiteClasses({TestConfig.class, TestWebApiBasicAuth.class})
public class P2TestsSuite{
}
