package fr.cactus.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.cactus.api.models.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
    
}
