package edu.njmsd.stonksmonkey.api.dto;

public class AuthData {
    private final String username;
    private final String password;

    public AuthData(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


}
