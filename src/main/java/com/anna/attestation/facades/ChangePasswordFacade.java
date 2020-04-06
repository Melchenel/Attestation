package com.anna.attestation.facades;

public interface ChangePasswordFacade {
    void resetPassword(String login);
    Boolean restorePassword(String login, String newPassword, String repeatPassword);
    Boolean changePassword(String oldPassword, String newPassword, String repeatPassword);
}
