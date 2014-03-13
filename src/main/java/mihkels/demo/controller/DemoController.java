package mihkels.demo.controller;

import mihkels.demo.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class DemoController {
   private final AtomicLong number = new AtomicLong();

    @RequestMapping("/demo")
    public Greeting demoMapping () {
        return new Greeting(number.incrementAndGet(), "Hello From Demo");
    }
}
