import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class HelloWorldServerTest {

    // TODO: work out how to make the integration tests start up the server themselves (and stop it)

    @Before
    // start the server

    @After
    // stop the server

    @Test
    public void whenServerIsHitSuccessfullyItRespondsWithA200StatusCode() {
        get("http://localhost:8080").then().statusCode(200);
    }

    @Test
    public void whenServerIsHitSuccessfullyTheResponseContainsNameAndGreeting() {
        get("http://localhost:8080").then().body(containsString("Hello Vanessa"));
    }

    @Test
    public void whenPOSTRequestIsSentItAcceptsANameAndRespondsWithNameSent() {
        given().
            param("name", "Bob").
        when().
            post("http://localhost:8080/").
        then().
            body(containsString("Bob"));
    }

    @Test
    public void afterAPostTheNameSentIsReturnedInASubsequentGet() {
        given().
            param("name", "Bob").
        when().
            post("http://localhost:8080/").
        then().
            body(containsString("Bob"));

        given().
            get("http://localhost:8080/").
        then().
            body(containsString("Hello Vanessa and Bob - the time on the server is "));
    }
}

