package com.anna.attestation.services;

import com.anna.attestation.entities.User;

public interface ChangePasswordService {
    void resetPassword(String login);
    void restorePassword(String login, String newPassword, String repeatPassword);
    void changePassword(User user, String oldPassword, String newPassword, String repeatPassword );
}
