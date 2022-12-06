package com.hvs.lab.shared.models;

import lombok.Data;

import java.io.Serializable;

@Data
public class Delivery implements Serializable {
    private OrderStatus orderStatus;
    private long orderId;
    private long id;
    private String vendorName;
}
