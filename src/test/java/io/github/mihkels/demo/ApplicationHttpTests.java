package io.github.mihkels.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webtestclient.autoconfigure.AutoConfigureWebTestClient;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class ApplicationHttpTests {
    @Autowired
    private WebTestClient client;

    @Test
    void apiReturnsAndIncrementsGreetings() {
        client.get().uri("/api").exchange()
                .expectStatus().isOk()
                .expectHeader().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)
                .expectBody()
                .jsonPath("$.id").isEqualTo(1)
                .jsonPath("$.content").isEqualTo("Hello World");

        client.get().uri("/api").exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.id").isEqualTo(2)
                .jsonPath("$.content").isEqualTo("Hello World");
    }

    @Test
    void counterUpdatesDemoGreeting() {
        client.get().uri("/demo").exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.id").isEqualTo(0)
                .jsonPath("$.content").isEqualTo("Hello from Demo");

        client.post().uri("/counter?message=hello").exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.current").isEqualTo(1)
                .jsonPath("$.message").isEqualTo("Counter value is: 1");

        client.get().uri("/demo").exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.id").isEqualTo(1)
                .jsonPath("$.content").isEqualTo("Hello from Demo");
    }
}
