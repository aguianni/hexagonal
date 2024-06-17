package com.example.hexagonal.infra.adapter.out;

import com.example.hexagonal.application.port.out.TaxValidatorPort;
import org.springframework.stereotype.Component;

@Component
public class TaxationTaxValidator implements TaxValidatorPort {
    @Override
    public boolean valid(String nif) {
        //restClient.get()....
        return true;
    }
}
