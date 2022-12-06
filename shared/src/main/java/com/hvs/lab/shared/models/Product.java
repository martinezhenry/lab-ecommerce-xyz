package com.hvs.lab.shared.models;

import lombok.Data;

import java.io.Serializable;

@Data
public class Product implements Serializable {
    private long id;
    private String name;
    private String description;
    private double price;
    private String sku;
}
