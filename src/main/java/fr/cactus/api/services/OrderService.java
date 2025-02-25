package fr.cactus.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.cactus.api.models.Order;
import fr.cactus.api.repositories.OrderRepository;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Optional<Order> getOrderWithExtras(Long orderId) {
        return orderRepository.findById(orderId);
    }

    public void makeOrder(Order order){
        orderRepository.save(order);
        
    }
// https://stackoverflow.com/questions/42993428/throw-exception-in-optional-in-java8
    
    
}
