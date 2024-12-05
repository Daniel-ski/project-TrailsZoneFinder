package com.example.trailszonefinder.web.dto;

import com.example.trailszonefinder.model.entity.Role;
import com.example.trailszonefinder.model.enums.Level;
import com.example.trailszonefinder.validation.annotation.PasswordsMatch;
import com.example.trailszonefinder.validation.annotation.UniqueEmail;
import com.example.trailszonefinder.validation.annotation.UniqueUsername;
import com.example.trailszonefinder.validation.annotation.WithoutDigits;
import jakarta.validation.constraints.*;

import java.util.Set;

@PasswordsMatch
public class UserRegisterDTO {
    @NotBlank
    @Size(min = 5, max = 20)
    @UniqueUsername
    private String username;

    @NotBlank
    @Size(min = 5,max = 200)
    private String password;

    @NotBlank
    @Size(min = 5,max = 200)
    private String confirmPassword;

    @NotBlank
    @Size(min = 2,max = 30)
    @WithoutDigits
    private String fullName;
    @NotBlank
    @Email(regexp = "^[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+)?@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}$"
            ,message = "Please insert a valid email!")
    @UniqueEmail
    private String email;

    @NotNull
    @Min(16)
    @Max(100)
    private int age;

    private Level level;



    public UserRegisterDTO() {
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}
