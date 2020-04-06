package com.anna.attestation.controllers;

import com.anna.attestation.facades.ChangePasswordFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PasswordController {

    @Autowired
    ChangePasswordFacade changePasswordFacade;

    @GetMapping("/login")
    public String getLogin(){

        return "/login";
    }

    @PostMapping("/login")
    public String getLogin(@RequestParam(name = "login") String login,
                           Model model){
        if(login!=null){
            changePasswordFacade.resetPassword(login,);
            model.addAttribute("message","На Вашу почту была отправлена ссылка для сброса пароля");
            //TODO:сделать страницу с сообщениями
        }
        return "redirect:/login";
    }

    @PostMapping("/resetPassword/{login}")
    public String resetPassword(@PathVariable(name = "login") String login,
                                @RequestParam(name = "newPassword") String newPassword,
                                @RequestParam(name = "repeatPassword") String repeatPassword){
        if(changePasswordFacade.changePassword(login,newPassword,repeatPassword)){
            return "/login";
        }

    }
}
