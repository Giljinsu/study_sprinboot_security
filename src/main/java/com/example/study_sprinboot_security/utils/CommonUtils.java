package com.example.study_sprinboot_security.utils;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class CommonUtils {
    public String getUniqueSequence() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
