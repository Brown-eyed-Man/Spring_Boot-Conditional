package ru.netology.springbootdemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.time.Duration;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringBootDemoApplicationTests {
    @Autowired
    private TestRestTemplate restTemplate;

    @Container
    private static final GenericContainer<?> dev = new GenericContainer<>("devapp")
            .withStartupTimeout(Duration.ofMinutes(9))
            .withExposedPorts(8080);
    @Container
    private static final GenericContainer<?> prod = new GenericContainer<>("prodapp")
            .withStartupTimeout(Duration.ofMinutes(9))
            .withExposedPorts(8081);

    @Test
    void testDevPort() {
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:" + dev.getMappedPort(8080) + "/profile", String.class);
        String expectedReturn = "Current profile is dev";
        Assertions.assertEquals(expectedReturn, forEntity.getBody());
    }

    @Test
    void testProdPort() {
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:" + prod.getMappedPort(8081) + "/profile", String.class);
        String expectedReturn = "Current profile is production";
        Assertions.assertEquals(expectedReturn, forEntity.getBody());
    }
}
