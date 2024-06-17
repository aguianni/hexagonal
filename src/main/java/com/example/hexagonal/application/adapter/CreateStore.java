package com.example.hexagonal.application.adapter;

import com.example.hexagonal.application.port.in.CreateStorePort;
import com.example.hexagonal.application.port.out.EventBrokerPort;
import com.example.hexagonal.application.port.out.TaxValidatorPort;
import com.example.hexagonal.domain.model.Store;
import com.example.hexagonal.domain.port.in.StoreServicePort;
import org.springframework.stereotype.Service;

@Service
public class CreateStore implements CreateStorePort {

    private StoreServicePort storeService;
    private EventBrokerPort eventBroker;
    private TaxValidatorPort taxValidator;

    public CreateStore(StoreServicePort storeService, EventBrokerPort eventBroker, TaxValidatorPort taxValidator) {

        this.storeService = storeService;
        this.eventBroker = eventBroker;
        this.taxValidator = taxValidator;
    }

    @Override
    public Store run(Store store) {

        Boolean valid =  taxValidator.valid(store.getNif());

        if(valid) {
            Store entity = storeService.save(store);
            eventBroker.send(entity);
            return entity;
        }
        throw new RuntimeException("NIF " + store.getNif() + "  invalid");
    }
}
