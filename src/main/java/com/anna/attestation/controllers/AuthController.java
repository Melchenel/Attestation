package com.anna.attestation.controllers;

import com.anna.attestation.facades.AutorizationFacade;
import com.anna.attestation.facades.FTAFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class AuthController {

    @Autowired
    private AutorizationFacade autorizationFacade;

    @Autowired
    private FTAFacade ftaFacade;

    @GetMapping("/auth")
    public String greeting(){
        return "auth";
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

    @PostMapping("/ftaPage")
    public String getAutenticationCode(@RequestParam(name = "code") String code){
        if(ftaFacade.getCode().equals(code)){

            return "main";
        }
        else {

            return "/auth";
        }
    }


}
