package edu.njmsd.stonksmonkey.api.controllers.auth;

import edu.njmsd.stonksmonkey.api.dto.AuthData;
import edu.njmsd.stonksmonkey.data.entities.User;
import edu.njmsd.stonksmonkey.data.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/sign-up")
    public void signUp(@RequestBody AuthData data) {
        userRepository.save(new User(data.getUsername(), passwordEncoder.encode(data.getPassword())));
    }
}
