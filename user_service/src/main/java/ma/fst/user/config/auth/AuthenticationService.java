package ma.fst.user.config.auth;

import lombok.RequiredArgsConstructor;
import ma.fst.user.config.JwtService;
import ma.fst.user.exception.UserNotFoundException;
import ma.fst.user.model.User;
import ma.fst.user.repository.UserRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public ResponseEntity<?> register(RegisterRequest request) {
        if (userRepo.findUserByEmail(request.getEmail()).isEmpty()) {
            var user = User.builder()
                    .firstname(request.getFirstname())
                    .lastname(request.getLastname())
                    .lastname(request.getLastname())
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .volunteerSkills(request.getVolunteerSkills())
                    .availableForTasks(request.isAvailableForTasks())
                    .build();

            userRepo.save(user);
            var jwtToken = jwtService.generateToken(user);

            return new ResponseEntity<>(AuthenticationResponse.builder()
                    .token(jwtToken)
                    .build(), HttpStatus.CREATED);
        }
        return new ResponseEntity<>("The email is already registered", HttpStatus.CONFLICT);
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        var user = userRepo.findUserByEmail(request.getEmail())
                .orElseThrow(()-> new UserNotFoundException("user not found (AuthenticationService Class user-service)"));
        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
