package com.anna.attestation.exeptions;

public class PasswordsToNotMatchException extends RuntimeException {
    private String login;

    public PasswordsToNotMatchException() {
    }
    public PasswordsToNotMatchException(String login) {
       this.login = login;
    }

    public String getLogin() {
        return login;
    }
}
