package edu.njmsd.stonksmonkey.security.utils;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class BearerTokenExtractor {

    private static final String HEADER = "Authorization";
    private static final String PREFIX = "Bearer ";

    public String extract(HttpServletRequest request) {
        String value = request.getHeader(HEADER);
        if (value != null && value.startsWith(PREFIX)) {
            return value.substring(PREFIX.length());
        }
        return null;
    }
}
