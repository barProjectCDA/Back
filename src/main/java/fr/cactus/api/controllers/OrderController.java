package fr.cactus.api.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.cactus.api.dto.OrderRequestDto;
import fr.cactus.api.dto.Response;
import fr.cactus.api.models.Order;
import fr.cactus.api.services.OrderService;

@RequestMapping("/api/order")
@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable Long id) {

        Optional<Order> optionalOrder = orderService.getOrderById(id);

        if (optionalOrder.isPresent()) {
            return new ResponseEntity<>(optionalOrder.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(new Response("error", "Identifiant utilisateur non connu."), HttpStatus.NOT_FOUND);
    }
    


    @PostMapping("/create")
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequestDto request) {
        Order order = orderService.createOrder(request);
        
        return ResponseEntity.ok(order);
    }
}
