package com.richiecodes.inventorymanager.payloads.request;

import java.util.Set;

public class SignupRequest {
    private String username;
    private String password;
    private Set<String> roles;
    private String fname;
    private String lname;

    public SignupRequest(String username, String password, Set<String> roles, String fname, String lname) {
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.fname = fname;
        this.lname = lname;
    }

    public Set<String> getRoles() {
        return roles;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
}
