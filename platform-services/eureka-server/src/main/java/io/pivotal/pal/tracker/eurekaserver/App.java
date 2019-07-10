package io.pivotal.pal.tracker.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class App {

    public static void main(String[] args) {

        //comment
        SpringApplication.run(App.class, args);
    }
}
