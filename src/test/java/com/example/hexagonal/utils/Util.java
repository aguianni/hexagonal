package com.example.hexagonal.utils;

import com.example.hexagonal.domain.model.Store;

import java.util.Arrays;
import java.util.List;

public class Util {
    static public List<Store> getStores() {
        return Arrays.asList(
                new Store(1L, "Espana", "F-112200", List.of()),
                new Store(2L, "Portugal", "F-112211", List.of()),
                new Store(3L, "Alemania", "F-112222", List.of())
        );
    }
}
