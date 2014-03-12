package mihkels.demo;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@Configurable
@EnableAutoConfiguration
@ComponentScan
public class Application {
    public static void main(String[] args) {
        // Run application
        SpringApplication.run(Application.class, args);

    }
}
