package com.example.Trusttalk;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderRunner {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "123456";
        String encryptedPassword = encoder.encode(rawPassword);
        System.out.println("Encrypted Password: " + encryptedPassword);
    }
}
