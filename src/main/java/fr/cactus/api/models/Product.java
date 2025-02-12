package fr.cactus.api.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
    @JoinColumn(name = "id_category", nullable = false)
    @JsonManagedReference
    private Category category;
}