package com.hvs.lab.ecommerce.persistence.services.implementations;

import com.hvs.lab.ecommerce.persistence.entities.OrderEntity;
import com.hvs.lab.ecommerce.persistence.repository.contracts.IOrderRepository;
import com.hvs.lab.ecommerce.persistence.services.contracts.IOrderService;
import com.hvs.lab.shared.models.Order;
import com.hvs.lab.shared.models.OrderStatus;
import com.hvs.lab.shared.models.Product;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Slf4j
public class OrderService implements IOrderService {

    private final IOrderRepository orderRepository;

    private final ModelMapper modelMapper;

    public OrderService(IOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public Order saveOrder(Order order) {
        log.info("convert object");
        OrderEntity orderEntity = modelMapper.map(order, OrderEntity.class);
        orderEntity.setLocalDateTime(LocalDateTime.now());
        orderEntity.setStatus(OrderStatus.IN_PROGRESS);
        order = calculateTotal(modelMapper.map(orderRepository.save(orderEntity), Order.class));
        return order;


    }

    @Override
    public Order calculateTotal(Order order) {
        double total = order.getProducts().parallelStream().mapToDouble(Product::getPrice).sum();
        order.setTotal(total);
        return order;
    }

    @Override
    public Order findOrder(long orderId){
        var orderE = orderRepository.findById(orderId);
        Order order = null;
        if (orderE.isPresent()) {
            order = this.modelMapper.map(orderE.get(), Order.class);
        }
        return order;
    }


}
