package com.anna.attestation.controllers;

import com.anna.attestation.entities.AuthInformation;
import com.anna.attestation.facades.ChangePasswordFacade;
import com.anna.attestation.facades.FTAFacade;
import com.anna.attestation.repositories.AuthInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("user")
public class ResetPasswordController {

    @Autowired
    private ChangePasswordFacade changePasswordFacade;

    @Autowired
    private FTAFacade ftaFacade;

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
            changePasswordFacade.resetPassword(login);
            ftaFacade.sendLinkOnMail(login);
            model.addAttribute("message","На Вашу почту была отправлена ссылка для сброса пароля");
            //TODO:сделать страницу с сообщениями
            //TODO:Аня, сделай нормально!!
            return "auth";
        }
        else{
            model.addAttribute("message","Вы мудак");
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
        if(changePasswordFacade.restorePassword(authInformation.getLogin(),newPassword,repeatPassword)){
            model.addAttribute("message","Вы молодец");
            return "auth";
        }
        else {
            model.addAttribute("message","Вы мудак");

            return "redirect:/restorePassword/" + model.getAttribute("login");
        }
    }

}
