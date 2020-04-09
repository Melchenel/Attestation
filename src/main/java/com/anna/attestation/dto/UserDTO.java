package com.anna.attestation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {

    private String login;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String role;


}
