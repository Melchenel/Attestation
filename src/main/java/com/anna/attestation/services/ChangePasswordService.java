package com.anna.attestation.services;

import com.anna.attestation.entities.User;

public interface ChangePasswordService {
    void resetPassword(String login);
    Boolean restorePassword(String login, String newPassword, String repeatPassword);
    Boolean changePassword(User user, String oldPassword, String newPassword, String repeatPassword );
}
