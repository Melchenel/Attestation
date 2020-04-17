package com.anna.attestation.controllers;

import com.anna.attestation.entities.AuthInformation;
import com.anna.attestation.repositories.AuthInformationRepository;
import com.anna.attestation.services.ChangePasswordService;
import com.anna.attestation.services.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("user")
public class ResetPasswordController {

    @Autowired
    private ChangePasswordService changePasswordService;

    @Autowired
    private MailService mailService;

    @Autowired
    private AuthInformationRepository authInformationRepo;

    private AuthInformation authInformation;

    @GetMapping("/login")
    public String getLogin(){

        return "/login";
    }

    @PostMapping("/login")
    public String resetPassword(@RequestParam(name = "login") String login,
                           Model model){
        if(!login.isEmpty()){
            changePasswordService.resetPassword(login);
            mailService.sendLinkOnMail(login);
            model.addAttribute("message","На Вашу почту была отправлена ссылка для сброса пароля");
            return "auth";
        }
        else{
            model.addAttribute("message","Что то пошло не так");
            return "redirect:/login";
        }

    }

    @GetMapping("/restorePassword/{login}")
    public String getResetPasswordPage(@PathVariable(name = "login") String login,
                                Model model){
        model.addAttribute("login",login );
        authInformation = authInformationRepo.findAuthInformationByLogin(login);
        return "restorePassword";
    }

    @GetMapping("/restorePassword")
    public String getResetPasswordPage(){
        return "restorePassword";
    }

    @PostMapping("/restorePassword")
    public String restorePassword(@RequestParam(name = "newPassword") String newPassword,
                                  @RequestParam(name = "repeatPassword") String repeatPassword,
                                  Model model){
        if(changePasswordService.restorePassword(authInformation.getLogin(),newPassword,repeatPassword)){
            model.addAttribute("message","Пароль успешно изменен");
            return "auth";
        }
        else {
            model.addAttribute("message","Пароли не совпадают");

            return "redirect:/restorePassword/" + model.getAttribute("login");
        }
    }

}
