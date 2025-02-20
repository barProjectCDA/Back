package fr.cactus.api.dto;

import java.util.List;

import fr.cactus.api.models.OrderProductExtra;

public record OrderDto(Long idClientTable, Long userId, Long orderId, List<OrderProductExtra> orderContent) {
    
}
// pas fini

