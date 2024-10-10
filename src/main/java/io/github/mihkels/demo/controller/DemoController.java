package io.github.mihkels.demo.controller;

import io.github.mihkels.demo.model.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class DemoController {
   private final AtomicLong number = new AtomicLong();

    @GetMapping("/demo")
    public Mono<Greeting> demoMapping () {
        return Mono.just(new Greeting(number.incrementAndGet(), "Hello From Demo"));
    }
}
