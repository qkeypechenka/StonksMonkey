package edu.njmsd.stonksmonkey.security.user;

import edu.njmsd.stonksmonkey.data.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class IdentifiableUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public IdentifiableUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new IdentifiableUser(user.getId(), user.getUsername(), user.getPassword(), Collections.emptyList());
    }
}
