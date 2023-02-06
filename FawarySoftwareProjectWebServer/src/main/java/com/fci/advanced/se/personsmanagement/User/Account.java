package com.fci.advanced.se.personsmanagement.User;

public class Account {
    public String getUsername() {
        return username;
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
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
    private  String username ;
    private  String password ;

}
