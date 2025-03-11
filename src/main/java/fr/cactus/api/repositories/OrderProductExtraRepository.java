package fr.cactus.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.cactus.api.models.OrderProductExtra;
@Repository
public interface OrderProductExtraRepository extends JpaRepository<OrderProductExtra, Long>{
    
}
