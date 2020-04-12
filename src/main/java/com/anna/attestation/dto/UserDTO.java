package com.anna.attestation.dto;


import com.anna.attestation.entities.User;

public class UserDTO {

    private static User user;

    public static boolean isEmpty(){
        if (user == null){
            return true;
        }
        else return false;
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        UserDTO.user = user;
    }
}
