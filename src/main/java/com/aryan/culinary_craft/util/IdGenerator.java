package com.aryan.culinary_craft.util;

import java.util.UUID;

public class IdGenerator {

    private IdGenerator() {
        // Private constructor to prevent instantiation
    }

    public static String generateUUID() {
        return UUID.randomUUID().toString();
    }
}

