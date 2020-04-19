package com.anna.attestation.controllers;

import com.anna.attestation.dto.UserDTO;
import com.anna.attestation.entities.AuthInformation;
import com.anna.attestation.entities.User;
import com.anna.attestation.repositories.AuthInformationRepository;
import com.anna.attestation.repositories.UserRepository;
import com.anna.attestation.services.AutorizationService;
import com.anna.attestation.services.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private AutorizationService autorizationService;

    @Autowired
    private MailService mailService;

    @Autowired
    private AuthInformationRepository authInformationRepo;

    @Autowired
    private UserRepository userRepository;


    private AuthInformation authInformation;

    @GetMapping("/")
    public String mainPage(){
        return "redirect:/auth";
    }

    @GetMapping("/auth")
    public String autentifacation(){
        return "auth";
    }

    @GetMapping("/ftaPage")
    public String ftaPage(){ return "ftaPage";}


    @PostMapping("/auth")
    public String autorization(@RequestParam(name = "login") String login,
                               @RequestParam(name = "password") String password,
                                Model model){
        if(autorizationService.signIn(login,password)){

            model.addAttribute("message", "Success");

            authInformation = authInformationRepo.findAuthInformationByLogin(login);
            mailService.sendCodeOnMail(authInformation);

            return "ftaPage";
        }
        else {
            model.addAttribute("message", "Error");
            return "redirect:/auth";
        }
    }


    @PostMapping("/ftaPage")
    public String getAutenticationCode(@RequestParam(name = "code") String code,
                                       Model model){
        if(checkCode(code)){

            initUser();
            initUserTest();
            authInformation.setCode("");
            authInformationRepo.save(authInformation);
            return "redirect:/main";
        }
        else {
            model.addAttribute("message", "Код неверный");
            return "redirect:/ftaPage";
        }
    }
    //TODO:refactor
    @PostMapping("/sendCodeOnPhone")
    public String sendCodeOnPhone(){
        mailService.sendCodeOnPhone(authInformation);
        return "redirect:/ftaPage";
    }

    @PostMapping("/repeatCode")
    public String repeatCode(){
        mailService.sendCodeOnMail(authInformation);
        return "redirect:/ftaPage";
    }

    private Boolean checkCode(String code){

        if(!code.isEmpty() && authInformation.getCode().equals(code)){
            return true;
        }
        else return false;

    }

    private void initUser(){
        UserDTO.setUser(userRepository.findUserByLogin(authInformation.getLogin()));
    }

    private void initUserTest(){
        User user = userRepository.findUserByLogin(authInformation.getLogin());
        /*userTest.setLogin(user.getLogin());
        userTest.setRole(user.getRole());
        userTest.setEmail(user.getEmail());
        userTest.setFirstName(user.getFirstName());
        userTest.setLastName(user.getLastName());
        userTest.setPhone(user.getPhoneNumber());*/

    }

}
