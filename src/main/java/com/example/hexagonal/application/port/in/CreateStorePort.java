package com.example.hexagonal.application.port.in;

import com.example.hexagonal.domain.model.Store;

public interface CreateStorePort {

    Store run(Store store);
}
