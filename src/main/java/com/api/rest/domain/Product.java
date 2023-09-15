package com.api.rest.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "reference", nullable = false)
    private String reference;
    @Column(name = "price", nullable = false)
    private double price;
    @Column(name = "weight", nullable = false)
    private double weight;
    @Column(name = "category", nullable = false)
    private String category;
    @Column(name = "stock", nullable = false)
    private int stock;

}
