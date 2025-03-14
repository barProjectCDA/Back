package fr.cactus.api.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

    @ManyToOne
    @JoinColumn(name = "id_category_1")
    @JsonBackReference 
    private Category mainCategory;

    @OneToMany(mappedBy = "mainCategory")
    @JsonManagedReference
    private List<Category> subCategories;

}