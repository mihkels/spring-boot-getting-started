package io.github.mihkels.demo.controller;

import io.github.mihkels.demo.model.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloController {
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/api")
    public Mono<Greeting> index () {
        return Mono.just(new Greeting(counter.incrementAndGet(), "Hello World"));
    }
}
