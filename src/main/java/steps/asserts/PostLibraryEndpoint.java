package steps.asserts;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasKey;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostLibraryEndpoint {

    public static <T> void shouldBeEquals(T actual, T expected) {

        assertEquals(expected, actual);
    }

    public static void checkStatusCode(Response response, int statusCode) {

        response
                .then()
                .statusCode(statusCode);
    }

    public static void commonErrorMessageShouldBeEquals(Response response, int code) {

        response
                .then()
                .assertThat()
                .body("errorCode", equalTo(code))
                .body("$", hasKey("errorDetails"));

        if (code == 1004) {
            response
                    .then()
                    .assertThat()
                    .body("errorMessage", equalTo("Указанный автор не существует в таблице"));
        } else {
            response
                    .then()
                    .assertThat()
                    .body("$", hasKey("errorMessage"));
        }
    }
}
