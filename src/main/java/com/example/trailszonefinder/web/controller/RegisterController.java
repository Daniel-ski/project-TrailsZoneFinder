package com.example.trailszonefinder.web.controller;

import com.example.trailszonefinder.model.enums.Level;
import com.example.trailszonefinder.service.UserServiceImpl;
import com.example.trailszonefinder.web.dto.UserRegisterDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @ModelAttribute("levels")
        public Level[] levels (){
        return Level.values();
    }

    @GetMapping()
    public String viewRegister(Model model) {
        if (!model.containsAttribute("registerData")){

            model.addAttribute("registerData",new UserRegisterDTO());
        }

//        model.addAttribute("levels", Level.values());

        return "register";
    }

    @PostMapping()
    public String doRegister(@Valid UserRegisterDTO userData,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("registerData",userData);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerData",bindingResult);

            return "redirect:/register";
        }

         userService.register(userData);
        return "redirect:/login";
    }
}
