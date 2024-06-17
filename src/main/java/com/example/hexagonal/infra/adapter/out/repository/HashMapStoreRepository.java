package com.example.hexagonal.infra.adapter.out.repository;

import com.example.hexagonal.domain.model.Store;
import com.example.hexagonal.domain.port.out.StoreRepositoryPort;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
@Qualifier("map")
public class HashMapStoreRepository implements StoreRepositoryPort {

    private Long idGen = 0L;

    private Map<Long, Store> map = new HashMap<>();

    @Override
    public Store save(Store store) {

        if(store.getId() == null){
            store.setId(idGen);
            idGen++;
        }
        map.put(store.getId(), store);
        return store;
    }

    @Override
    public List<Store> findAll() {

        return map.values().stream().collect(Collectors.toList());
    }

    @Override
    public List<Store> findByNif(String nif) {
        return map.values().stream().filter(it -> it.getNif().equals(nif)).collect(Collectors.toList());
    }

    @Override
    public Store getReferenceById(Long id) {
        Store store = map.get(id);
        if(store == null){
            throw new EntityNotFoundException();
        }
        return store;
    }
}
