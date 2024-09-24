package com.example.trailszonefinder.model.entity;

import com.example.trailszonefinder.model.enums.Level;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
    @NotBlank
    @Size(min = 5, max = 20)
    @Column(nullable = false)
    private String username;

    @NotBlank
    @Size(min = 5,max = 200)
    @Column(nullable = false)
    private String password;

    @NotBlank
    @Size(min = 2,max = 30)
    @Column(name = "full_name")
    private String fullName;

    @NotNull
    @Min(16)
    @Max(100)
    private int age;

    @NotBlank
    @Email
    private String email;

    @ManyToMany
    private Set<Role> roles;

    @Enumerated(EnumType.STRING)
    private Level level;


    public User() {
        this.roles = new HashSet<>();
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }


}
