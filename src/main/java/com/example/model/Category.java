package com.example.model;

import java.util.Arrays;

public enum Category {
    BUSINESS_SECTORS_AND_SUBJECTS,
    METHODOLOGIES,
    OPERATING_SYSTEMS,
    SOFT_SKILLS,
    TECHNOLOGIES,
    TOOLS;

    public static Category valueOfIgnoreCase(String value) {
        return Arrays.stream(Category.values()).filter(category -> category.name().equalsIgnoreCase(value)).findFirst().orElseThrow(() -> new IllegalArgumentException("Kan category niet parsen: " + value));
    }
}
