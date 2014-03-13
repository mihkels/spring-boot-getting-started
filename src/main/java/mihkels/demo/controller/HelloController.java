package mihkels.demo.controller;

import mihkels.demo.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/api")
    public @ResponseBody Greeting index () {
        return new Greeting(counter.incrementAndGet(), "Hello World");
    }
}
