package com.example.hexagonal.domain.port.in;

import com.example.hexagonal.domain.model.Store;

import java.util.List;

public interface StoreServicePort {

    Store save(Store store);

    List<Store> findAll();

    Store getById(Long id);
}
