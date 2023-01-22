package pl.degath;

import io.micronaut.http.MediaType;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import jakarta.inject.Inject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;


@MicronautTest
public class StudentPerformanceControllerTest {

    @Inject
    EmbeddedServer embeddedServer;

    @BeforeEach
    public void setup() {
        RestAssured.baseURI = embeddedServer.getURL().toString();
    }

    @Test
    @Disabled("todo fix - Cannot serialize because cannot determine how to serialize content-type multipart/form-data")
    public void testSortByPerformance() {
        byte[] bytes = "Charlie,50.0\nLucy,80.0\nLinus,60\n".getBytes();
        RequestSpecification request = RestAssured.given()
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .multiPart("file", bytes, MediaType.MULTIPART_FORM_DATA)
                .multiPart("algorithm", "bubble");

        request.post("/v1/students/sortByPerformance")
                .then()
                .assertThat()
                .statusCode(200)
                .body("resultSize", equalTo(3)); // assert the size of the result
    }
}