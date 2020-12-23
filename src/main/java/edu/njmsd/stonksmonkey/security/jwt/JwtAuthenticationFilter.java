package edu.njmsd.stonksmonkey.security.jwt;

import edu.njmsd.stonksmonkey.security.utils.BearerTokenExtractor;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final BearerTokenExtractor tokenExtractor;
    private final JwtSettings jwtSettings;
    private final UserDetailsService userDetailsService;

    public JwtAuthenticationFilter(
            BearerTokenExtractor tokenExtractor,
            JwtSettings jwtSettings,
            UserDetailsService userDetailsService) {
        this.tokenExtractor = tokenExtractor;
        this.jwtSettings = jwtSettings;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        var token = tokenExtractor.extract(request);
        if (token != null) {
            try {
                var username = Jwts.parserBuilder()
                        .setSigningKey(jwtSettings.getSigningKey())
                        .build()
                        .parseClaimsJws(token)
                        .getBody()
                        .getSubject();
                var user = userDetailsService.loadUserByUsername(username);
                var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } catch (Exception ignored) {
            }
        }
        filterChain.doFilter(request, response);
    }
}
