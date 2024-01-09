package ma.fst.user;

import lombok.extern.slf4j.Slf4j;
import ma.fst.user.config.auth.AuthenticationService;
import ma.fst.user.config.auth.RegisterRequest;
import ma.fst.user.model.enumeration.Role;
import ma.fst.user.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(AuthenticationService service, UserService userService) {
        return args -> {
            RegisterRequest user = RegisterRequest.builder()
                    .firstname("Antonio")
                    .lastname("Rüdiger")
                    .email("antonio@mail.com")
                    .password("password")
                    .build();
            log.info("Admin Token: "+ service.register(user).getBody());
            RegisterRequest user2 = RegisterRequest.builder()
                    .firstname("Mark")
                    .lastname("Smith")
                    .email("mark@mail.com")
                    .password("password")
                    .build();
            log.info("Volunteer Token: "+ service.register(user2).getBody());
            userService.addRoleToUser(1L, Role.ADMIN);
            userService.addRoleToUser(2L, Role.VOLUNTEER);
        };
    }

}