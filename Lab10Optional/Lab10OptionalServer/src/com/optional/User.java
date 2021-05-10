package com.optional;

import java.util.List;

public class User {

    public String name;
    public List<User> friends;
    public List<String> messages;

    public String getName() {
        return name;
    }

    public User(String name) {
        this.name = name;
    }
}
