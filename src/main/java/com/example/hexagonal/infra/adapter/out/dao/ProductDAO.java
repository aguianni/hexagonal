package com.example.hexagonal.infra.adapter.out.dao;

import com.example.hexagonal.domain.model.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDAO {

    public ProductDAO(Product product) {
        this.name = product.getName();
        this.color = product.getColor();
        this.size = product.getSize();
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;

    String name;

    String color;

    String size;
}
