package edu.njmsd.stonksmonkey.api.security;

import edu.njmsd.stonksmonkey.data.repositories.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ApiUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    public ApiUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username.equals("admin")) {
            return new ApiUser(
                    0,
                    "admin",
                    "$2a$10$0Nv/Qa7m8DdjWpBS2XRZWeP8rWDB7OdScb2grQSRDS9I9fWWlBNG2",
                    new ArrayList<>());
        }
        var user = userRepository.findByUsername(username).orElse(null);
        if (user == null) throw new UsernameNotFoundException("User not found");
        return new ApiUser(user.getId(), user.getUsername(), user.getPassword(), new ArrayList<>());
    }
}
