package com.anna.attestation.repositories;

import com.anna.attestation.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findUserByLogin(String login);
}
