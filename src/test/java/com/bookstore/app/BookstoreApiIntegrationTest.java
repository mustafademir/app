package com.bookstore.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

@SpringBootTest(classes = AppApplication.class,
        webEnvironment = WebEnvironment.RANDOM_PORT)
public class BookstoreApiIntegrationTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void addBook() {
        ResponseEntity<String> responseEntity = this.restTemplate
                .getForEntity("http://localhost:" + port + "/bookstore/addBook?bookstoreId=1?bookId=1", String.class);
        assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Test
    public void removeBook() {
        ResponseEntity responseEntity = this.restTemplate
                .getForObject("http://localhost:" + port + "/bookstore/removeBook?bookstoreId=1?bookId=1", ResponseEntity.class);
        assertEquals(200, responseEntity.getStatusCodeValue());
    }
}
