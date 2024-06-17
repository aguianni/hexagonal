package com.example.hexagonal.domain.port.out;

import com.example.hexagonal.domain.model.Store;

import java.util.List;

public interface StoreRepositoryPort {

    Store save(Store store);

    List<Store> findAll();

    List<Store> findByNif(String nif);

    Store getReferenceById(Long id);
}
