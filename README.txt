To run the tests in docker do following:

1. clone the project
2. docker build -t hw4 .
3. docker run hw4

If no parameters are specified, then P1 tests will be executed. If you want to run some exact test or suit, then specify the paramether -Dtest.
Possible options:
docker run hw4 -Dtest="TestConfig"
docker run hw4 -Dtest="TestWebApiBasicAuth"
docker run hw4 -Dtest="TestLoginPage"
docker run hw4 -Dtest="P2TestsSuite"
docker run hw4 -Dtest="UITestSuite"

NOTE: UI tests fail due to SessionNotCreatedException. I assume this is because of 'FROM' image doesn't contain Chrome browser.
