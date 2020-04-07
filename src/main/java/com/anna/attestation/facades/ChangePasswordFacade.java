package com.anna.attestation.facades;

import com.anna.attestation.entities.AuthInformation;

public interface ChangePasswordFacade {
    void resetPassword(String login);
    Boolean restorePassword(String login, String newPassword, String repeatPassword);
    Boolean changePassword(AuthInformation authInformation, String oldPassword,String newPassword, String repeatPassword );
}
