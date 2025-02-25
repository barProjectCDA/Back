package fr.cactus.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.cactus.api.models.ClientTable;

@Repository
public interface ClientTableRepository extends JpaRepository<ClientTable,Long> {
    Optional<ClientTable> findById(Long id);
}
