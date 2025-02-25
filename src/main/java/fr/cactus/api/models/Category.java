package fr.cactus.api.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
@Table(name = "\"category\"")
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Category {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "\"id_category\"")
    private Long categoryId;

    @Column(name = "\"name_category\"", nullable = false)
    private String name_category;

    @Column(name = "\"css_hexadecimal_color\"")
    private String cssHexadecimalColor;

    // Relation reflexive : Une catégorie peut avoir une catégorie principale (many to one)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"id_category_1\"") // Cette colonne lie la catégorie principale à la catégorie courante
    @JsonBackReference
    private Category mainCategory;

    // Relation OneToMany pour les sous-catégories
    @OneToMany(mappedBy = "mainCategory", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Category> subCategories;
}
