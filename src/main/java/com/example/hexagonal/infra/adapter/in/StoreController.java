package com.example.hexagonal.infra.adapter.in;

import com.example.hexagonal.application.port.in.CreateStorePort;
import com.example.hexagonal.application.port.in.GetAllStoresPort;
import com.example.hexagonal.domain.model.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("store")
public class StoreController {

    private CreateStorePort createStoreTask;
    private GetAllStoresPort getAllStoreTask;

    @Autowired
    public StoreController(CreateStorePort createStoreTask, GetAllStoresPort getAllTask) {
        this.createStoreTask = createStoreTask;
        this.getAllStoreTask = getAllTask;
    }

    @PostMapping
    public Store create(@RequestBody Store store) {
        return createStoreTask.run(store);
    }

    @GetMapping(path = "")
    public List<Store> getAll() {
        return getAllStoreTask.run();
    }

}
