package fr.cactus.api.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "\"product\"")
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "\"id_product\"")
    private Long productId;

    @Column(name = "\"name_product\"", nullable = false)
    private String name;

    @Column(name = "\"price_product\"", nullable = false)
    private Double price;

    @Column(name = "\"css_hexadecimal_color\"")
    private String cssHexadecimalColor;


    @ManyToOne
    @JsonIgnore
    @JsonBackReference
    @JoinColumn(name = "id_category", nullable = false)
    private Category category;

    @ManyToMany
    @JsonManagedReference
    @JoinTable(
        name = "product_extra", 
        joinColumns = @JoinColumn(name = "id_product"), 
        inverseJoinColumns = @JoinColumn(name = "id_extra")
    )
    private List<Extra> extras;
}