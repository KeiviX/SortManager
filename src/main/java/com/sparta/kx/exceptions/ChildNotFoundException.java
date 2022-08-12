package com.sparta.kx.exceptions;

public class ChildNotFoundException extends RuntimeException {
    public ChildNotFoundException(String errorMessage) {
        super("No child in this direction.");
    }
}
