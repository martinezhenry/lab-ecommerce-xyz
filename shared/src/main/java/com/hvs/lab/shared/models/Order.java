package com.hvs.lab.shared.models;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Order {
    private long id;
    private LocalDateTime localDateTime;
    private List<Product> products;
    private double total;

}
