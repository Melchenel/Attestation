package com.anna.attestation.controllers;

import com.anna.attestation.facades.AutorizationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class AuthController {

    @Autowired
    private AutorizationFacade autorizationFacade;

    @GetMapping("/auth")
    public String greeting(){
        return "auth";
    }

    @PostMapping("/auth")
    public String autorization(@RequestParam(name = "login") String login,
                               @RequestParam(name = "password") String password,
                                Model model){
        if(autorizationFacade.signIn(login,password)){
            model.addAttribute("message", "Success");
            return "main";
        }
        else {
            model.addAttribute("message", "Error");
            return "redirect:/auth";
        }
    }
}
