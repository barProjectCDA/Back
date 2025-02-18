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
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"id_bar_user\"")
    private Long userId;

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

    public Users(String firstName, String lastName, String username, boolean isAdmin, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.isAdmin = isAdmin;
        this.password = password;
    }
}
