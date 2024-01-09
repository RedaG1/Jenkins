package ma.fst.aid;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class AidApplication {
    public static void main(String[] args) {
        SpringApplication.run(AidApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            log.info("The Aid application started!");
        };
    }
}