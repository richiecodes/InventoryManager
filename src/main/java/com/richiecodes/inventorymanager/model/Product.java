package com.richiecodes.inventorymanager.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "perishable")
    private boolean perishable;

    @Column(name = "QTY")
    private Integer qty;
}
