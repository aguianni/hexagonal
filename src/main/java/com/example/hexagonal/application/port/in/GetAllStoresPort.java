package com.example.hexagonal.application.port.in;

import com.example.hexagonal.domain.model.Store;

import java.util.List;

public interface GetAllStoresPort {

    List<Store> run();
}
