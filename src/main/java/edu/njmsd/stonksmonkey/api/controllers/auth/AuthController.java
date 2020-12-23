package edu.njmsd.stonksmonkey.api.controllers.auth;

import edu.njmsd.stonksmonkey.api.dto.CredentialsDto;
import edu.njmsd.stonksmonkey.api.dto.TokenDto;
import edu.njmsd.stonksmonkey.data.entities.User;
import edu.njmsd.stonksmonkey.data.repositories.UserRepository;
import edu.njmsd.stonksmonkey.security.jwt.JwtFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtFactory jwtFactory;

    public AuthController(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            AuthenticationManager authenticationManager,
            JwtFactory jwtFactory) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtFactory = jwtFactory;
    }

    @PostMapping("/sign-up")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void signUp(@RequestBody CredentialsDto credentials) {
        if (userRepository.findByUsername(credentials.getUsername()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "The user already exists");
        }
        userRepository.save(new User(credentials.getUsername(), passwordEncoder.encode(credentials.getPassword())));
    }

    @PostMapping("/sign-in")
    public TokenDto signIn(@RequestBody CredentialsDto credentials) {
        var authRequest = new UsernamePasswordAuthenticationToken(credentials.getUsername(), credentials.getPassword());
        try {
            var authentication = authenticationManager.authenticate(authRequest);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return new TokenDto(jwtFactory.createAccessToken(authentication.getName()));
        } catch (AuthenticationException exception) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, exception.getMessage(), exception);
        }
    }
}
