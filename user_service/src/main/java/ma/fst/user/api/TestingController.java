package ma.fst.user.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("hasAnyRole('ADMIN')")
public class TestingController {
    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("<h1>Hello from user-service</h1>", HttpStatus.OK);
    }
}
