package com.anna.attestation.controllers;

import com.anna.attestation.dto.UserDTO;
import com.anna.attestation.entities.AuthInformation;
import com.anna.attestation.facades.ChangePasswordFacade;
import com.anna.attestation.repositories.AuthInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserProfileController {

    @Autowired
    private ChangePasswordFacade changePasswordFacade;

    @Autowired
    private AuthInformationRepository authInformationRepo;

    private AuthInformation authInformation;

    @GetMapping("/main")
    public String getAccountPage(@ModelAttribute("user") UserDTO user){
            if(user.isEmpty()) {

                return "redirect:/auth";
            }
            else return "redirect:/main/" + user.getLogin();

    }



    @GetMapping("/main/{userId}")
    public String getAccountPage(@PathVariable(name = "userId") String userId,
                                 @ModelAttribute("user") UserDTO user,
                                 Model model){
        if(user.isEmpty()){
            return "redirect:/auth";

        }else {
            System.out.println(user.getLogin());
            //model.addAttribute("user", user);
            return "main";
        }
    }


    @PostMapping("/changePassword")
    public String changePassword(@RequestParam(name = "oldPassword") String oldPassword,
                                 @RequestParam(name = "newPassword") String newPassword,
                                 @RequestParam(name = "repeatPassword") String repeatPassword,
                                 Model model){
        if(changePasswordFacade.changePassword(authInformation, oldPassword, newPassword, repeatPassword)){
            model.addAttribute("message", "Ваш пароль успешно изменен");
        }else {
            model.addAttribute("message", "Вы мудень");
        }
        return "redirect:/main/" + authInformation.getLogin();
    }

    @PostMapping("/logout")
    public String logout(@ModelAttribute("user") UserDTO user){
        user = null;

        return "redirect:/auth";
    }
}
