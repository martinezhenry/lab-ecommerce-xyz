package com.hvs.lab.ecommerce.persistence.entities;

import com.hvs.lab.shared.models.OrderStatus;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime localDateTime;
    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    private List<ProductEntity> products;
    private OrderStatus status;
    private double total;

}
