import com.ness.helloworld.HelloWorldServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.containsString;

public class HelloWorldServerTest {

    @Before
    public void setUp() {
        String[] args = new String[0];
        try {
            HelloWorldServer.main(args);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() {
        HelloWorldServer.stop();
    }

    @Test
    public void whenServerIsHitSuccessfullyItRespondsWithA200StatusCode() {
        get("http://localhost:8080/").then().statusCode(200);
    }

    @Test
    public void whenServerIsHitSuccessfullyTheResponseContainsNameAndGreeting() {
        get("http://localhost:8080/").then().body(containsString("Hello Vanessa"));
    }

    @Test
    public void whenPOSTRequestIsSentItAcceptsANameAndRespondsWithNameSent() {
        given().
            body("name=Bob").
        when().
            post("http://localhost:8080/names").
        then().
            body(containsString("Bob"));
    }

    @Test
    public void afterAPostTheNameSentIsReturnedInASubsequentGet() {
        given().
                body("name=Bob").
                when().
                post("http://localhost:8080/names").
                then().
                body(containsString("Bob"));
        given().
            get("http://localhost:8080/").
        then().
            body(containsString("Hello Vanessa and Bob - the time on the server is "));
    }

    @Test
    public void aGetOnTheNamesURLReturnsAllNames() {
        given().
                body("name=Bob").
                when().
                post("http://localhost:8080/names").
                then().
                body(containsString("Bob"));
        get("http://localhost:8080/names").then().body(containsString("Vanessa, Bob"));
    }

    @Test
    public void sendingADeleteOnANameRemovesThatName() {
        given().
                body("name=Bob").
                when().
                post("http://localhost:8080/names").
                then().
                body(containsString("Bob"));
        delete("http://localhost:8080/names/Bob").then().body(containsString("Bob"));

        get("http://localhost:8080/").then().body(containsString("Hello Vanessa - the time on the server is"));
    }

    @Test
    public void sendingAPutOnANameReceives201StatusCode() {
        given().
                body("name=Bob").
            when().
                post("http://localhost:8080/names");

        given().body("name=James").when().put("http://localhost:8080/names/Bob").then().statusCode(201);
    }
}

