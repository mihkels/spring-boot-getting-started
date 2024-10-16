package io.github.mihkels.demo.controller;

import io.github.mihkels.demo.model.Counter;
import io.github.mihkels.demo.model.CounterRequest;
import io.github.mihkels.demo.model.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class DemoController {
    private static final String DEFAULT_MESSAGE = "Hello from Demo";
    private final AtomicLong counter = new AtomicLong();
    private String currentMessage;

    @GetMapping("/demo")
    public Mono<Greeting> demoMapping () {
        return Mono.just(new Greeting(counter.get(), DEFAULT_MESSAGE));
    }

    @PostMapping("/counter")
    public Mono<Counter> counterMapping(CounterRequest request) {
        currentMessage = request.message();
        counter.incrementAndGet();
        return Mono.just(new Counter(counter.get()));
    }
}
