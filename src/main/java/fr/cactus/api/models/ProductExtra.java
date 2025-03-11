package fr.cactus.api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class ProductExtra {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_extra")
    private Extra extra;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;
}
