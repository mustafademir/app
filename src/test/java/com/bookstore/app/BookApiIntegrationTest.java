package com.bookstore.app;

import org.springframework.boot.web.server.LocalServerPort;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

@SpringBootTest(classes = AppApplication.class,
        webEnvironment = WebEnvironment.RANDOM_PORT)
public class BookApiIntegrationTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void changeCategory() {
        ResponseEntity<String> responseEntity = this.restTemplate
                .getForEntity("http://localhost:" + port + "/book/changeCategory?cId=1?bookId=1", String.class);
        assertEquals(200, responseEntity.getStatusCodeValue());
    }
}
