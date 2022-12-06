package com.hvs.lab.ecommerce.persistence.entities;

import com.hvs.lab.shared.models.OrderStatus;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class DeliveryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long orderId;
    private OrderStatus orderStatus;
    private String vendorName;
}
