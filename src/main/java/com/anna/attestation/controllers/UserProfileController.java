package com.anna.attestation.controllers;

import com.anna.attestation.entities.AuthInformation;
import com.anna.attestation.facades.ChangePasswordFacade;
import com.anna.attestation.repositories.AuthInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserProfileController {

    @Autowired
    private ChangePasswordFacade changePasswordFacade;

    @Autowired
    private AuthInformationRepository authInformationRepo;

    private AuthInformation authInformation;

    @GetMapping("/main/{login}")
    public String getAccountPage(@PathVariable(name = "login") String login,
                                 Model model){
        authInformation = authInformationRepo.findAuthInformationByLogin(login);
        model.addAttribute("user", login);
        return "main";
    }


    @PostMapping("/changePassword")
    public String changePassword(@RequestParam(name = "oldPassword") String oldPassword,
                                 @RequestParam(name = "newPassword") String newPassword,
                                 @RequestParam(name = "repeatPassword") String repeatPassword,
                                 Model model){
        if(changePasswordFacade.changePassword(authInformation, oldPassword, newPassword, repeatPassword)){
            model.addAttribute("message", "Ваш пароль успешно изменен");
        }
        model.addAttribute("message", "Вы мудень");
        return "main";
    }
}
