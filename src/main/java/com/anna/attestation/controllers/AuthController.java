package com.anna.attestation.controllers;

import com.anna.attestation.entities.AuthInformation;
import com.anna.attestation.facades.AutorizationFacade;
import com.anna.attestation.facades.FTAFacade;
import com.anna.attestation.repositories.AuthInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class AuthController {

    @Autowired
    private AutorizationFacade autorizationFacade;

    @Autowired
    private FTAFacade ftaFacade;

    @Autowired
    private AuthInformationRepository authInformationRepo;

    private AuthInformation authInformation;

    @GetMapping("/")
    public String mainPage(){
        return "redirect:/auth";
    }

    @GetMapping("/auth")
    public String autentifacation(){
        return "auth";
    }

    @PostMapping("/auth")
    public String autorization(@RequestParam(name = "login") String login,
                               @RequestParam(name = "password") String password,
                                Model model){
        if(autorizationFacade.signIn(login,password)){
            model.addAttribute("message", "Success");
            ftaFacade.sendCodeOnMail(login);

            authInformation = authInformationRepo.findAuthInformationByLogin(login);

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
            model.addAttribute("user", authInformation.getLogin());
            return "redirect:/main/" + authInformation.getLogin();
        }
        else {
            model.addAttribute("user", "Вы облажались");
            return "redirect:/ftaPage";
        }
    }

    private Boolean checkCode(String code){

        if(!code.isEmpty() && authInformation.getCode().equals(code)){
            return true;
        }
        else return false;

    }

}
