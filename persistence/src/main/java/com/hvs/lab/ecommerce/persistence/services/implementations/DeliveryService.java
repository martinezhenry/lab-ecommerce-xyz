package com.hvs.lab.ecommerce.persistence.services.implementations;

import com.hvs.lab.ecommerce.persistence.entities.DeliveryEntity;
import com.hvs.lab.ecommerce.persistence.repository.contracts.IDeliveryRepository;
import com.hvs.lab.ecommerce.persistence.services.contracts.IDeliveryService;
import com.hvs.lab.ecommerce.persistence.services.contracts.IOrderService;
import com.hvs.lab.shared.models.Delivery;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService implements IDeliveryService {

    private IDeliveryRepository deliveryRepository;
    private ModelMapper modelMapper;

    public DeliveryService(IDeliveryRepository deliveryRepository, IOrderService orderService){
        this.deliveryRepository = deliveryRepository;
        this.modelMapper = new ModelMapper();
    }
    @Override
    public Delivery findDelivery(long deliveryId) {
        var deliveryEntity = deliveryRepository.findById(deliveryId);
        Delivery delivery = null;
        if (deliveryEntity.isPresent()) {
            delivery = modelMapper.map(deliveryEntity.get(), Delivery.class);
        }
        return delivery;
    }

    @Override
    public Delivery save(Delivery delivery) {
        var deliveryEntity = this.modelMapper.map(delivery, DeliveryEntity.class);
        var rsp = this.deliveryRepository.save(deliveryEntity);
        return this.modelMapper.map(rsp, Delivery.class);
    }
}
