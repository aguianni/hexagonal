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
public class StoreDAO {

    public StoreDAO(Store store) {
        this.address = store.getAddress();
        this.nif = store.getNif();
        this.products = store.getProducts().stream().map(it -> new ProductDAO(it)).collect(Collectors.toList());
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;

    String address;

    String nif;

    @OneToMany(cascade = CascadeType.ALL)
    List<ProductDAO> products;

    public Store convert(){
        List<Product> products = this.getProducts().stream().map(p -> new Product(p.getId(), p.getName(), p.getColor(), p.getSize())).collect(Collectors.toList());
        return new Store(this.getId(), this.getAddress(), this.getNif(), products);
    }
}
