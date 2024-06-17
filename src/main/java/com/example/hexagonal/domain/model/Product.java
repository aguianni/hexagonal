package com.example.hexagonal.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class Product {

    Long id;

    String name;

    String color;

    String size;
}
