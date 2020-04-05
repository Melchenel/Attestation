package com.anna.attestation.controllers;

import com.anna.attestation.facades.ResetPasswordFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PasswordController {

    @Autowired
    ResetPasswordFacade resetPasswordFacade;

    @PostMapping("/login")
    public String getLogin(@RequestParam(name = "login") String login,
                           Model model){
        if(login!=null){
            resetPasswordFacade.resetPassword(login);
            model.addAttribute("message","На Вашу почту была отправлена ссылка для сброса пароля");
        }
        return "redirect:/login";
    }
}
