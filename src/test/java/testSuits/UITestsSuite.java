package testSuits;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import testSuits.categories.UITests;
import tests.ui.TestLoginPage;

@RunWith(Categories.class)
@Categories.IncludeCategory(UITests.class)
@Suite.SuiteClasses(TestLoginPage.class)
public class UITestsSuite{}
