package com.example.hexagonal.infra.adapter.out;

import com.example.hexagonal.application.port.out.EventBrokerPort;
import com.example.hexagonal.domain.model.Store;
import org.springframework.stereotype.Component;

@Component
public class KAFKAEventBroker implements EventBrokerPort {
    @Override
    public void send(Store store) {
        //producer.send ....
    }
}
