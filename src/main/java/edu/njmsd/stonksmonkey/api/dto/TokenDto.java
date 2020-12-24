package edu.njmsd.stonksmonkey.api.dto;

public class TokenDto {

    private final String accessToken;

    public TokenDto(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }
}
