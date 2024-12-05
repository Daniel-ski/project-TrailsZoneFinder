package com.example.trailszonefinder.service;

import com.example.trailszonefinder.web.dto.UserLoginDTO;
import com.example.trailszonefinder.web.dto.UserProfileDTO;
import com.example.trailszonefinder.web.dto.UserRegisterDTO;

public interface UserService {
    void register(UserRegisterDTO userData);
    boolean login(UserLoginDTO userLogin);
    UserProfileDTO getUserProfileData();
    void logout();

    boolean isUsernameUnique(String username);

    boolean isEmailUnique(String email);
}
