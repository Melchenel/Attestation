package com.anna.attestation.facades.impl;

import com.anna.attestation.facades.ChangePasswordFacade;
import org.springframework.stereotype.Component;

@Component
public class DefaultChangePasswordFacade implements ChangePasswordFacade {
    @Override
    public void resetPassword(String login) {

    }

    @Override
    public Boolean changePassword(String login, String newPassword, String repeatPassword) {
        return null;
    }
}
