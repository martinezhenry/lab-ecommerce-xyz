package com.hvs.lab.ecommerce.persistence.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private OrderEntity order;
    private String name;
    private String description;
    private double price;
    private String sku;
}
