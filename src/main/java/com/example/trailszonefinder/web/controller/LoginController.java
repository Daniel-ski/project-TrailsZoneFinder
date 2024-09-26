package com.example.trailszonefinder.web.controller;

import com.example.trailszonefinder.service.UserServiceImpl;
import com.example.trailszonefinder.web.dto.UserLoginDTO;
import com.example.trailszonefinder.web.dto.UserProfileDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    private final UserServiceImpl userService;

    public LoginController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public ModelAndView viewLogin(ModelAndView mav){
        mav.addObject("loginData",new UserLoginDTO());
        mav.setViewName("login");
        return mav;
    }

    @PostMapping("/login")
    public ModelAndView login(ModelAndView mav,UserLoginDTO userData){
        if (this.userService.login(userData)) {
            mav.setViewName("redirect:/home");
        }
        return mav;
    }

    @GetMapping("/profile")
    public ModelAndView viewProfile(ModelAndView mav){
        mav.addObject("profileData",userService.getUserProfileData());
        mav.setViewName("profile");
        return mav;
    }

    @PostMapping("/logout")
    public ModelAndView logout(ModelAndView mav){
        userService.logout();
        mav.setViewName("redirect:/home");

        return mav;
    }

//    @PostMapping("/profile")
//    public ModelAndView getProfileData(ModelAndView mav, UserProfileDTO profileDTO){
//        mav.addObject("profileData",profileDTO);
//        mav.setViewName("/profile");
//        return mav;
//    }
}
