package fr.cactus.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.cactus.api.dtos.OrderRequestDto;
import fr.cactus.api.dtos.OrderRequestExtraDto;
import fr.cactus.api.models.ClientTable;
import fr.cactus.api.models.Extra;
import fr.cactus.api.models.Order;
import fr.cactus.api.models.OrderProductExtra;
import fr.cactus.api.models.Product;
import fr.cactus.api.models.User;
import fr.cactus.api.repositories.ClientTableRepository;
import fr.cactus.api.repositories.ExtraRepository;
import fr.cactus.api.repositories.OrderProductExtraRepository;
import fr.cactus.api.repositories.OrderRepository;
import fr.cactus.api.repositories.ProductRepository;
import fr.cactus.api.repositories.UserRepository;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderProductExtraRepository orderProductExtraRepository;
    private final UserRepository userRepository;
    private final ClientTableRepository clientTableRepository;
    private final ExtraRepository extraRepository;
    private final ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository, OrderProductExtraRepository orderProductExtraRepository,
            UserRepository userRepository, ClientTableRepository clientTableRepository, ExtraRepository extraRepository,
            ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.orderProductExtraRepository = orderProductExtraRepository;
        this.userRepository = userRepository;
        this.clientTableRepository = clientTableRepository;
        this.extraRepository = extraRepository;
        this.productRepository = productRepository;
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public Order createOrder(OrderRequestDto request) {
        User user = userRepository.findById(request.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));

        ClientTable table = clientTableRepository.findById(request.getClientTableId()).orElseThrow(() -> new RuntimeException("Table not found"));

        Order order = new Order();
        order.setClientTable(table);
        order.setUser(user);
        order.setStatusOrder(true);
        order.setPriceOrder(0);
        
        List<OrderProductExtra> orderProductExtras = new ArrayList<>();
        List<OrderRequestExtraDto> orderProductExtrasDto = request.getOrderProductExtras();
        double totalPrice = 0.0; 

        
        for (OrderRequestExtraDto orderProductExtraDto : orderProductExtrasDto) {
            Product product = productRepository.findById(orderProductExtraDto.getProductId()).orElseThrow(() -> new RuntimeException("Product not found"));
            List<Long> idExtras = orderProductExtraDto.getExtraIds();
            double totalPriceExtra = 0.0;
            totalPrice += product.getPrice();
            

            List<Extra> extrasToInsert = new ArrayList<>();
            for (Long idExtra : idExtras) {
                Extra extra = extraRepository.findById(idExtra).orElseThrow(() -> new RuntimeException("Extra not found"));
                extrasToInsert.add(extra);
                totalPrice += extra.getExtraPrice();
                totalPriceExtra += extra.getExtraPrice();
            }
            OrderProductExtra orderProductExtra = new OrderProductExtra();
            orderProductExtra.setOrder(order);
            orderProductExtra.setProduct(product);
            orderProductExtra.setExtras(extrasToInsert);
            orderProductExtra.setStatusOrder(false);
            orderProductExtra.setPriceOrder(totalPriceExtra);
            
            orderProductExtras.add(orderProductExtra);  
        }

        order.setOrderProductExtras(orderProductExtras);
        order.setPriceOrder(totalPrice);
        return orderRepository.save(order);
    }

// https://stackoverflow.com/questions/42993428/throw-exception-in-optional-in-java8
}
