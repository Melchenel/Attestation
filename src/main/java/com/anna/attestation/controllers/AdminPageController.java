package com.anna.attestation.controllers;

import com.anna.attestation.services.AdministartionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminPageController {

    @Autowired
    private AdministartionService administartionService;

    @PostMapping("/delete")
    public String deleteUser(@RequestParam(name = "login") String login,
                             Model model){
        if(administartionService.deleteUser(login)){
            model.addAttribute("messageAboutDelete", "Пользователь удален");
        }
        else {
            model.addAttribute("messageAboutDelete", "Такого пользователя не существует или вы пытаетесь удалить администартора");
        }

        return "redirect:/main";
    }

    @PostMapping("/add")
    public String addUser(@RequestParam(name = "login") String login,
                          @RequestParam(name = "firstName") String firstName,
                          @RequestParam(name = "lastName") String lastName,
                          @RequestParam(name = "email") String email,
                          @RequestParam(name = "phone") String phone,
                          Model model){

        if(administartionService.addUser(login,firstName,lastName,email,phone)){
            model.addAttribute("messageAboutAdd", "Пользователь добавлен");
        }
        else {
            model.addAttribute("messageAboutAdd", "Пользователь с таким логином уже существует");
        }
        return "redirect:/main";
    }

}
