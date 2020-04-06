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

    @GetMapping("/")
    public String greeting(){
        return "redirect:/auth";
    }

    @PostMapping("/auth")
    public String autorization(@RequestParam(name = "login") String login,
                               @RequestParam(name = "password") String password,
                                Model model){
        if(autorizationFacade.signIn(login,password)){
            model.addAttribute("message", "Success");
            ftaFacade.sendCodeOnMail(login);
            return "ftaPage";
        }
        else {
            model.addAttribute("message", "Error");
            return "redirect:/auth";
        }
    }

    //TODO:подумать как передать логин нормально
    @PostMapping("/ftaPage")
    public String getAutenticationCode(@RequestParam(name = "code") String code,
                                       Model model){
        if(checkCode(code, model)){
           // model.addAttribute("user", "user");
            return "main";
        }
        else {
            model.addAttribute("user", "Вы облажались");
            return "redirect:/ftaPage";
        }
    }

    //TODO:refactor this
    private Boolean checkCode(String code, Model model){
        List<AuthInformation> authInformations = authInformationRepo.findAll();
        for (AuthInformation authInfo : authInformations){
            System.out.println(authInfo.getCode());
            if(code!=null && authInfo.getCode().equals(code)){
                authInfo.setCode("0");
                authInformationRepo.save(authInfo);
                model.addAttribute("user", authInfo);
                return true;
            }
        }
        return false;
    }

}
