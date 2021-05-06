package app.a;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;

@SpringBootApplication
public class ApplicationA implements ApplicationRunner {

    @Autowired
    private DiscoveryClient discoveryClient;

    public static void main(String[] args) {
        SpringApplication.run(ApplicationA.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(discoveryClient.getInstances("service-b").get(0).getUri().toString());
    }
}
