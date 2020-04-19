package com.anna.attestation;

import com.anna.attestation.exeptions.NoSuchUserException;
import com.anna.attestation.exeptions.OldPasswordNotMatch;
import com.anna.attestation.exeptions.PasswordsToNotMatchException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Handler {

    @ExceptionHandler(PasswordsToNotMatchException.class)
    public String handlerException(PasswordsToNotMatchException ex, Model model){
        model.addAttribute("message", "Пароль не был изменен, так как пароли не совпадают" );

        return "redirect:/restorePassword/" + ex.getLogin();
    }

    @ExceptionHandler(OldPasswordNotMatch.class)
    public String handlerException(OldPasswordNotMatch ex, Model model){
        model.addAttribute("message", "Пароль не был изменен, так как пароли не совпадают" );
        return "redirect:/main";
    }

    @ExceptionHandler(NoSuchUserException.class)
    public String handlerException(NoSuchUserException ex, Model model){

        model.addAttribute("messageForAdmin", "Действие не выполнено" );
        return "redirect:/main";
    }
}
