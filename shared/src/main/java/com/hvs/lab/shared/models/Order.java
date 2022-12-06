package com.hvs.lab.shared.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
public class Order implements Serializable {
    private long id;
    private LocalDateTime localDateTime;
    private List<Product> products;
    private double total;
    private OrderStatus status;

}
