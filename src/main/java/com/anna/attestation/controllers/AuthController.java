package com.anna.attestation.controllers;

import com.anna.attestation.dto.UserDTO;
import com.anna.attestation.entities.AuthInformation;
import com.anna.attestation.entities.User;
import com.anna.attestation.facades.AutorizationFacade;
import com.anna.attestation.facades.FTAFacade;
import com.anna.attestation.repositories.AuthInformationRepository;
import com.anna.attestation.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@ControllerAdvice
@SessionAttributes("user")
public class AuthController {

    @Autowired
    private AutorizationFacade autorizationFacade;

    @Autowired
    private FTAFacade ftaFacade;

    @Autowired
    private AuthInformationRepository authInformationRepo;

    @Autowired
    private UserRepository userRepository;

    private AuthInformation authInformation;

    @ModelAttribute("user")
    public UserDTO setUpUserForm() {
        return new UserDTO();
    }

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
        if(autorizationFacade.signIn(login,password)){
            model.addAttribute("message", "Success");

            authInformation = authInformationRepo.findAuthInformationByLogin(login);
            ftaFacade.sendCodeOnMail(authInformation);

            return "ftaPage";
        }
        else {
            model.addAttribute("message", "Error");
            return "redirect:/auth";
        }
    }


    @PostMapping("/ftaPage")
    public String getAutenticationCode(@RequestParam(name = "code") String code,
                                       @ModelAttribute("user") UserDTO user,
                                       Model model){
        if(checkCode(code)){
            initUser(user);
            authInformation.setCode("");
            authInformationRepo.save(authInformation);
            return "redirect:/main";
        }
        else {
            model.addAttribute("user", "Вы облажались");
            return "redirect:/ftaPage";
        }
    }
    //TODO:refactor
    @PostMapping("/sendCodeOnPhone")
    public String sendCodeOnPhone(){
        ftaFacade.sendCodeOnPhone(authInformation);
        return "redirect:/ftaPage";
    }

    @PostMapping("/repeatCode")
    public String repeatCode(){
        ftaFacade.sendCodeOnMail(authInformation);
        return "redirect:/ftaPage";
    }

    private Boolean checkCode(String code){

        if(!code.isEmpty() && authInformation.getCode().equals(code)){
            return true;
        }
        else return false;

    }

    private void initUser(UserDTO user){
            User userEntity = userRepository.findUserByLogin(authInformation.getLogin());
            user.setLogin(userEntity.getLogin());
            user.setEmail(userEntity.getEmail());
            user.setFirstName(userEntity.getFirstName());
            user.setLastName(userEntity.getLastName());
            user.setRole(userEntity.getRole());
            user.setPhone(userEntity.getPhoneNumber());
    }

}
