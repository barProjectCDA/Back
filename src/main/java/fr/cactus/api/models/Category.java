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
@Table(name = "\"category\"")
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "\"id_category\"")
    private Long categoryId;

    @Column(name = "\"name_category\"", nullable = false)
    private String name_category;

    @Column(name = "\"css_hexadecimal_color\"")
    private String cssHexadecimalColor;

    @ManyToOne
    @JoinColumn(name = "id_category_1")
    @JsonManagedReference
    private Category mainCategory;

}
