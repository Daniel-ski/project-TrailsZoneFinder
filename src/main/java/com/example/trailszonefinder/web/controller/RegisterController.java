package com.example.trailszonefinder.web.controller;

import com.example.trailszonefinder.model.enums.Level;
import com.example.trailszonefinder.service.UserServiceImpl;
import com.example.trailszonefinder.web.dto.UserRegisterDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final UserServiceImpl userService;

    @Autowired
    public RegisterController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ModelAndView viewRegister(ModelAndView mav) {
        mav.addObject("registerData",new UserRegisterDTO());
        mav.addObject("levels", Level.values());
        mav.setViewName("register");

        return mav;
    }

    @PostMapping()
    //todo: make this method to return ModelAndView
    public String doRegister(UserRegisterDTO userData,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            //todo: handle errors
        }
        userService.register(userData);

        return "redirect:/login";
    }
}
