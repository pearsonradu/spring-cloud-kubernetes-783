package app.b;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;

@SpringBootApplication
public class ApplicationB implements ApplicationRunner {

    @Autowired
    private DiscoveryClient discoveryClient;

    public static void main(String[] args) {
        SpringApplication.run(ApplicationB.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(discoveryClient.getInstances("service-a").get(0).getUri().toString());
    }
}
