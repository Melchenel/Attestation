package com.anna.attestation.facades;

public interface ChangePasswordFacade {
    void resetPassword(String login);
    Boolean changePassword(String login, String newPassword, String repeatPassword);
}
