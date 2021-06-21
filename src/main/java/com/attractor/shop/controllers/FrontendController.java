package com.attractor.shop.controllers;

import com.attractor.shop.entities.UserRegisterForm;
import com.attractor.shop.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping
@AllArgsConstructor
public class FrontendController {
    private final UserService userService;
    @GetMapping("/profile")
    public String pageUserProfile(Model model, Principal principal){
        var user = userService.getByEmail(principal.getName());
        model.addAttribute("dto",user);
        return "profile.html";
    }

    @GetMapping("/register")
    public String pageRegisterUser(Model model){
        if (!model.containsAttribute("user")){
            model.addAttribute("user",new UserRegisterForm());
        }
        return "register.html";
    }
    @PostMapping("/register")
    public String registerPage(@Valid UserRegisterForm userRequestDto,
                               BindingResult validationResult,
                               RedirectAttributes attributes){
        //attributes.addFlashAttribute("dro", userRequestDto);
        if (validationResult.hasFieldErrors()){
            attributes.addFlashAttribute("errors", validationResult.getFieldErrors());
                return "redirect:/register";
            }
        userService.register(userRequestDto);
        return "redirect:/login";
        }

        @GetMapping("/login")
        public String loginPage(@RequestParam(required = false, defaultValue = "false")Boolean error, Model model){
            model.addAttribute("error", error);
            return "login.html";
        }
    }
