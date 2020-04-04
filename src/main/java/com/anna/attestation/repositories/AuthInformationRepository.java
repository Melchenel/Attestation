package com.anna.attestation.repositories;

import com.anna.attestation.entities.AuthInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthInformationRepository extends JpaRepository<AuthInformation, String> {
    AuthInformation findAuthInformationByLogin(String login);
}
