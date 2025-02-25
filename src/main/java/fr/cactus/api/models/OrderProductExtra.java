package fr.cactus.api.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "\"order_product_extra\"")
public class OrderProductExtra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"id_order_product_extra\"")
    private Long idOrderProductExtra;

    @ManyToOne
    @JoinColumn(name = "\"id_product\"", nullable = false)
    private Product product;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "\"id_order\"", nullable = false)
    private Order order;

    @Column(name = "\"price_order\"", nullable = false)
    private Double priceOrder;

    @Column(name = "\"status_order\"")
    private boolean statusOrder;

    @ManyToMany
    @JoinTable(
            name = "associated_extra",
            joinColumns = @JoinColumn(name = "id_order_product_extra"),
            inverseJoinColumns = @JoinColumn(name = "id_extra")
    )
    private List<Extra> extras;
}
