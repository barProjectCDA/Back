package fr.cactus.api.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Table (name="\"order_product_extra\"")
public class OrderProductExtra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"id_order_product_extra\"")
    private Long productNumber;

    @ManyToOne
    @JoinColumn(name = "\"id_product\"", nullable = false)
    private Product product;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "\"id_order\"", nullable = false)
    private Order order;

    @JsonIgnore
    @Column(name = "\"price_order\"", nullable = false)
    private Double priceOrder;

    @JsonIgnore
    @Column(name = "\"status_order\"")
    private boolean statusOrder;
    @JsonBackReference
    @ManyToMany(mappedBy = "orderProductExtras")
    private List<Extra> extras;

}
