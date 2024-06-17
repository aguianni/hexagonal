package com.example.hexagonal.application.port.out;

public interface TaxValidatorPort {

    boolean valid(String nif);
}
