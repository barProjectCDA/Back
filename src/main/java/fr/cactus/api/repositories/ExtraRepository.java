package fr.cactus.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.cactus.api.models.Extra;


@Repository
public interface ExtraRepository extends JpaRepository<Extra,Long>{
}
    