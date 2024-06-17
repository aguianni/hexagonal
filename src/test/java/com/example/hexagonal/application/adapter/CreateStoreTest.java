package com.example.hexagonal.application.adapter;

import com.example.hexagonal.application.port.out.EventBrokerPort;
import com.example.hexagonal.application.port.out.TaxValidatorPort;
import com.example.hexagonal.domain.model.Store;
import com.example.hexagonal.domain.port.in.StoreServicePort;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class CreateStoreTest {

    @Mock
    StoreServicePort storeService;
    @Mock
    EventBrokerPort eventBroker;

    @Mock
    TaxValidatorPort taxValidator;

    @Test
    public void saveTest(){

        CreateStore createStore = new CreateStore(storeService, eventBroker, taxValidator);

        Store store = new Store(null, "nueva calle", "F-112233", List.of());
        Store storeNew = new Store(1L, "nueva calle", "F-112233", List.of());

        when(storeService.save(store)).thenReturn(storeNew);
        when(taxValidator.valid(store.getNif())).thenReturn(true);

        Assert.assertEquals(1L, createStore.run(store).getId().longValue());

        verify(storeService, times(1)).save(store);
        verify(taxValidator, times(1)).valid(store.getNif());
        verify(eventBroker, times(1)).send(storeNew);
    }

    @Test
    public void saveTestFail(){

        CreateStore createStore = new CreateStore(storeService, eventBroker, taxValidator);

        Store store = new Store(null, "nueva calle", "F-112233", List.of());
        Store storeNew = new Store(1L, "nueva calle", "F-112233", List.of());

        when(storeService.save(store)).thenReturn(storeNew);
        when(taxValidator.valid(store.getNif())).thenReturn(false);

        Assert.assertThrows(RuntimeException.class, () -> {
            createStore.run(store);
        });

        verify(storeService, times(0)).save(store);
        verify(taxValidator, times(1)).valid(store.getNif());
    }
}
