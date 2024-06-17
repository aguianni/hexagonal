package com.example.hexagonal.infra.adapter.out.repository;

import com.example.hexagonal.infra.adapter.out.dao.StoreDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface H2StoreJPARepository extends JpaRepository<StoreDAO, Long> {

    StoreDAO save(StoreDAO store);

    List<StoreDAO> findAll();
    List<StoreDAO> findByNif(String nif);
}
