package pl.gregorymartin.as8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class As8Application {

    public static void main(String[] args) {
        SpringApplication.run(As8Application.class, args);
    }

}
