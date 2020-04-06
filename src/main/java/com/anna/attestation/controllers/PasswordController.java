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
    public String resetPassword(@RequestParam(name = "login") String login,
                           Model model){
        if(login!=null){
            changePasswordFacade.resetPassword(login);
            model.addAttribute("message","На Вашу почту была отправлена ссылка для сброса пароля");
            //TODO:сделать страницу с сообщениями
        }
        return "redirect:/login";
    }

    @GetMapping("/resetPassword/{login}")
    public String restorePassword(@PathVariable(name = "login") String login){
        return "restorePassword";
    }


    @PostMapping("/resetPassword/{login}")
    public String restorePassword(@PathVariable(name = "login") String login,
                                  @RequestParam(name = "newPassword") String newPassword,
                                  @RequestParam(name = "repeatPassword") String repeatPassword,
                                  Model model){
        if(changePasswordFacade.restorePassword(login,newPassword,repeatPassword)){
            model.addAttribute("message","Вы молодец");
            return "/login";
        }
        else {
            model.addAttribute("message","Вы мудак");
            return "redirect:/resetPassword/" + login;
        }

    }
}
