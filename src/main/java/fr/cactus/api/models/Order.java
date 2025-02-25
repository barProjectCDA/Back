package fr.cactus.api.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "\"order\"")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"id_order\"")
    private Long idOrder;

    @ManyToOne
    @JoinColumn(name = "\"id_bar_user\"", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "\"id_client_table\"", nullable = false)
    private ClientTable clientTable;

    @Column(name = "\"price_order\"", nullable = false)
    private double priceOrder;

    @Column(name = "\"status_order\"")
    private boolean statusOrder;

    @OneToMany(mappedBy="order",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderProductExtra> orderProductExtras;

}
