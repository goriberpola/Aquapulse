package com.example.aquapulse;

public class Users {
    String username,Name,email;

    public Users() {
    }

    public String getUsername() {
        return username;
    }



    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Users(String username, String name, String email) {
        this.username = username;
        this.Name = name;
        this.email = email;
    }
}
