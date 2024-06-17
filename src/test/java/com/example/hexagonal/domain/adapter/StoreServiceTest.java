package com.example.hexagonal.domain.adapter;

import com.example.hexagonal.domain.model.Store;
import com.example.hexagonal.domain.port.out.StoreRepositoryPort;
import com.example.hexagonal.utils.Util;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class StoreServiceTest {

    @Mock
    StoreRepositoryPort repository;

    @Test
    public void saveTest(){

        StoreService service =  new StoreService(repository);
        Store store = new Store(null, "Francia", "F-112222", List.of());
        Store result = new Store(1L, "Francia", "F-112222", List.of());
        when(repository.findByNif("F-112222")).thenReturn(List.of());
        when(repository.save(store)).thenReturn(result);

        Store entity = service.save(store);

        Assert.assertEquals(1L, entity.getId().longValue());
        verify(repository, times(1)).save(store);
        verify(repository, times(1)).findByNif("F-112222");
    }

    @Test
    public void saveFail(){

        StoreService service =  new StoreService(repository);
        Store store = new Store(null, "Francia", "F-112222", List.of());
        when(repository.findByNif("F-112222")).thenThrow(new DuplicateKeyException("NIF"));

        Assert.assertThrows(RuntimeException.class, () -> {
            service.save(store);
        });

        verify(repository, times(1)).findByNif("F-112222");
        verify(repository, times(0)).save(store);
    }

    @Test
    public void findAllTest(){

        StoreService service =  new StoreService(repository);

        List<Store> list = Util.getStores();

        when(repository.findAll()).thenReturn(list);

        Assert.assertEquals(list.size(), service.findAll().size());

        verify(repository, times(1)).findAll();
    }

    @Test
    public void getByIdTest(){

        StoreService service =  new StoreService(repository);

        List<Store> list = Util.getStores();

        when(repository.getReferenceById(1L)).thenReturn(list.get(0));

        Assert.assertEquals(list.get(0).getId(), service.getById(1L).getId());

        verify(repository, times(1)).getReferenceById(1L);
    }
}
