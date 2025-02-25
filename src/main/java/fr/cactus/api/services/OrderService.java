package fr.cactus.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.cactus.api.models.Order;
import fr.cactus.api.repositories.OrderProductExtraRepository;
import fr.cactus.api.repositories.OrderRepository;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderProductExtraRepository orderProductExtraRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository,OrderProductExtraRepository orderProductExtraRepository) {
        this.orderRepository = orderRepository;
        this.orderProductExtraRepository = orderProductExtraRepository;
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

// https://stackoverflow.com/questions/42993428/throw-exception-in-optional-in-java8

}
