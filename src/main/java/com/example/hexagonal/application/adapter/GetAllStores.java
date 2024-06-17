package com.example.hexagonal.application.adapter;

import com.example.hexagonal.application.port.in.GetAllStoresPort;
import com.example.hexagonal.domain.model.Store;
import com.example.hexagonal.domain.port.in.StoreServicePort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllStores implements GetAllStoresPort {

    private StoreServicePort storeService;

    public GetAllStores(StoreServicePort storeService) {
        this.storeService = storeService;
    }

    @Override
    public List<Store> run() {
        return storeService.findAll();
    }
}
