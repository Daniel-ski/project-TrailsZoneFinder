package com.example.trailszonefinder.web.controller;

import com.example.trailszonefinder.model.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope()
public class CurrentUser {
    private User user;

    public CurrentUser() {
    }

    public boolean isLoggedIn(){
        return this.user != null;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
