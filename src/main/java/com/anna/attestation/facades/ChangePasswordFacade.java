package com.anna.attestation.facades;

import com.anna.attestation.entities.AuthInformation;
import com.anna.attestation.entities.User;

public interface ChangePasswordFacade {
    void resetPassword(String login);
    Boolean restorePassword(String login, String newPassword, String repeatPassword);
    Boolean changePassword(User user, String oldPassword, String newPassword, String repeatPassword );
}
