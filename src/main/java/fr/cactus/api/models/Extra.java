package fr.cactus.api.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
@Table(name="\"extra\"")
public class Extra {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "\"id_extra\"")
    private Long idExtra;


    @Column(name= "\"name_extra\"")
    private String extraName;

    @Column(name= "\"price_extra\"")
    private Double extraPrice;

    @JsonManagedReference
    @ManyToMany
    @JsonIgnore
    @JoinTable(
        name = "associated_extra", 
        joinColumns = @JoinColumn(name = "id_extra"), 
        inverseJoinColumns = @JoinColumn(name = "id_order_product_extra")
    )
    private List<OrderProductExtra> orderProductExtras;
}
