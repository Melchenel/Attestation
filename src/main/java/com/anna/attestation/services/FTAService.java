package com.anna.attestation.services;

public interface FTAService {
    Boolean sendMessage(String code, String email);
}
