package com.example.hexagonal.infra.adapter.out.repository;

import com.example.hexagonal.domain.model.Store;
import com.example.hexagonal.domain.port.out.StoreRepositoryPort;
import com.example.hexagonal.infra.adapter.out.dao.StoreDAO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@Qualifier("h2")
@Primary
public class H2StoreRepository implements StoreRepositoryPort {

    H2StoreJPARepository h2Repo;

    public H2StoreRepository(H2StoreJPARepository repository) {
        this.h2Repo = repository;
    }

    @Override
    public Store save(Store store) {
        StoreDAO dao = h2Repo.save(new StoreDAO(store));
        return dao.convert();
    }

    @Override
    public List<Store> findAll() {
        List<StoreDAO> daos = h2Repo.findAll();
        return daos.stream().map(dao -> dao.convert() ).collect(Collectors.toList());
    }

    @Override
    public List<Store> findByNif(String nif) {
        List<StoreDAO> daos = h2Repo.findByNif(nif);
        return daos.stream().map(dao -> dao.convert() ).collect(Collectors.toList());
    }

    @Override
    public Store getReferenceById(Long id) {
        StoreDAO dao = h2Repo.getReferenceById(id);
        return dao.convert();
    }
}
