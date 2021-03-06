package com.anna.attestation.controllers;

import com.anna.attestation.dto.UserDTO;
import com.anna.attestation.dto.UserTest;
import com.anna.attestation.entities.AuthInformation;
import com.anna.attestation.repositories.AuthInformationRepository;
import com.anna.attestation.repositories.UserRepository;
import com.anna.attestation.services.ChangePasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("user")
public class UserProfileController {

    @Autowired
    private ChangePasswordService changePasswordService;

    @Autowired
    private AuthInformationRepository authInformationRepo;

    @Autowired
    private UserRepository userRepository;

    private AuthInformation authInformation;

    @GetMapping("/main")
    public String getAccountPage(){
            if(UserDTO.isEmpty()) {

                return "redirect:/auth";
            }
            else return "redirect:/main/" + UserDTO.getUser().getLogin();

    }

    @GetMapping("/main/{login}")
    public String getAccountPage(@PathVariable(name = "login") String login,
                                 Model model){
        if(UserDTO.isEmpty()){
            return "redirect:/auth";
        }else {

            model.addAttribute("user", UserDTO.getUser());
            if(UserDTO.getUser().getRole() == 2){
                model.addAttribute("users", userRepository.findAll());
            }
            return "main";
        }
    }

    @PostMapping("/changePassword")
    public String changePassword(@RequestParam(name = "oldPassword") String oldPassword,
                                 @RequestParam(name = "newPassword") String newPassword,
                                 @RequestParam(name = "repeatPassword") String repeatPassword,
                                 Model model){

        changePasswordService.changePassword(UserDTO.getUser(), oldPassword, newPassword, repeatPassword);
        model.addAttribute("message", "Ваш пароль успешно изменен");

        return "redirect:/main/" + UserDTO.getUser().getLogin();
    }

    @PostMapping("/logout")
    public String logout(){
        UserDTO.setUser(null);
        return "redirect:/auth";
    }
}
