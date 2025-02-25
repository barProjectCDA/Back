package fr.cactus.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "\"bar_user\"")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"id_bar_user\"")
    private Integer userId;

    @Column(name = "\"firstName\"")
    private String firstName;
    @JsonIgnore
    @Column(name = "\"role\"")
    private boolean isAdmin;

    @Column(name = "\"lastName\"")
    private String lastName;
    @Column(name = "\"username\"")
    private String username;
    @JsonIgnore
    @Column(name = "\"password\"")
    private String password;




}
