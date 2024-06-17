package com.example.hexagonal.domain.adapter;

import com.example.hexagonal.domain.model.Store;
import com.example.hexagonal.domain.port.in.StoreServicePort;
import com.example.hexagonal.domain.port.out.StoreRepositoryPort;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService implements StoreServicePort {

    private StoreRepositoryPort repository;

    public StoreService(StoreRepositoryPort repository) {
        this.repository = repository;
    }

    public Store save (Store store) {

        if(repository.findByNif(store.getNif()).isEmpty()){
            return repository.save(store);
        } else {
            throw new DuplicateKeyException("NIF " + store.getNif() + " already exists");
        }
    }

    public List<Store> findAll () {

        return repository.findAll();
    }

    @Override
    public Store getById(Long id) {

        return repository.getReferenceById(id);
    }

}
