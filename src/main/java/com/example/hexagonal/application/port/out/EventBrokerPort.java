package com.example.hexagonal.application.port.out;

import com.example.hexagonal.domain.model.Store;

public interface EventBrokerPort {

    void send(Store store);
}
