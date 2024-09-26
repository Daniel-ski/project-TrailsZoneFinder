package com.example.trailszonefinder.service;

import com.example.trailszonefinder.model.entity.User;
import com.example.trailszonefinder.repository.UserRepository;
import com.example.trailszonefinder.web.controller.CurrentUser;
import com.example.trailszonefinder.web.dto.UserLoginDTO;
import com.example.trailszonefinder.web.dto.UserProfileDTO;
import com.example.trailszonefinder.web.dto.UserRegisterDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper mapper;

    private final CurrentUser currentUser;



    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, ModelMapper mapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.mapper = mapper;
        this.currentUser = currentUser;
    }

    public void register(UserRegisterDTO userData) {

        if (this.userRepository.findByUsername(userData.getUsername()).isPresent() && currentUser.isLoggedIn()) {
            //todo: throw exception
        } else {
            User userToRegister = this.mapper.map(userData, User.class);
            String encodePassword = this.passwordEncoder.encode(userToRegister.getPassword());
            userToRegister.setPassword(encodePassword);
//            userToRegister.setRoles(new Role().setName(UserRole.ADMIN)));


            this.userRepository.save(userToRegister);
        }
    }

    public boolean login(UserLoginDTO userLogin){

        Optional<User> optionalUser = this.userRepository.findByUsername(userLogin.getUsername());

        if (optionalUser.isPresent()) {
            if (this.passwordEncoder.matches(userLogin.getPassword(),optionalUser.get().getPassword())) {
                currentUser.setUser(optionalUser.get());
                return true;
            }
            //todo: return wrong username or password;
        }
        return false;
    }

    public UserProfileDTO getUserProfileData(){
        return this.mapper.map(currentUser.getUser(), UserProfileDTO.class);
    }

    public void logout() {
        this.currentUser.setUser(null);
    }
}
