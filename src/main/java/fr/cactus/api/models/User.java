package fr.cactus.api.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    private Long userId;

    @NotBlank(message = "First name is required")
    @NotNull(message = "First name is required")
    @Size(max = 50, message = "First name lenght not valid")
    @Column(name = "\"firstName\"")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(max = 50, message = "Last name lenght not valid")
    @Column(name = "\"lastName\"")
    private String lastName;

    @NotBlank(message = "Username is required")
    @Size(max = 50, message = "Username lenght not valid")
    @Column(name = "\"username\"")
    private String username;

    @NotBlank(message = "Role is required")
    @Size(max = 50, message = "Role size not valid")
    @Column(name = "\"role\"")
    private String role;

    @NotBlank(message = "Password is required")
    @Size(min = 60, max = 60, message = "Password lenght not valid")
    @Column(name = "\"password\"")
    private String password;

    public User(String firstName, String lastName, String username, String role, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.role = role;
        this.password = password;
    }
}


