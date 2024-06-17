package com.example.hexagonal.application.adapter;

import com.example.hexagonal.domain.port.in.StoreServicePort;
import com.example.hexagonal.utils.Util;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class GetAllStoresTest {

    @Mock
    StoreServicePort storeService;

    @Test
    public void saveTest(){

        GetAllStores getAllStores = new GetAllStores(storeService);

        when(storeService.findAll()).thenReturn(Util.getStores());

        Assert.assertEquals(1L, getAllStores.run().get(0).getId().longValue());

        verify(storeService, times(1)).findAll();
    }
}
