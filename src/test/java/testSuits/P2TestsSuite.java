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
    //@BeforeClass and @AfterClass in the SuiteClasses are executed in a strange order if the suite is run.
    //The order is clear and expected if I run the TestWebApiBasicAuth separately.
    //What happens with @BeforeClass and @AfterClass when suits are used???
}
