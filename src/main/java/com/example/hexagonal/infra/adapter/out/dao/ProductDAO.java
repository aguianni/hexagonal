package com.example.hexagonal.infra.adapter.out.dao;

import com.example.hexagonal.domain.model.Product;
import com.example.hexagonal.domain.model.Store;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
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

    public Product convert(){
        return new Product(this.getId(), this.getName(), this.getColor(), this.getSize());
    }
}
