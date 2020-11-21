package com.ticketing.utils;

public enum Gender {
    MALE("Male"), FEMALE("female");

    private final String value;

    private Gender(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
