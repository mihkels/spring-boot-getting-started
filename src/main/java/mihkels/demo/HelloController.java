package mihkels.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index () {
        return "bla bla bla";
    }

    @RequestMapping("/demo")
    public String list () {
        return "Hello from here too";
    }

    @RequestMapping("/start")
    public String demoPage () {
        return "Test project building";
    }
}
