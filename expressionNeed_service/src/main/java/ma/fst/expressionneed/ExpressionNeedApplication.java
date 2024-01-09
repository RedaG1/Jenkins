package ma.fst.expressionneed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ExpressionNeedApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExpressionNeedApplication.class, args);
    }
}