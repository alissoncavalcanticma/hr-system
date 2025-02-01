package br.com.ctfera.user_api.domain;

import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.GenerationType.IDENTITY;

//@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "TB_USER")
public class User {

    //@EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    private Double hourlyPrice;

    public User(Long id, String name, String email, String password, Double hourlyPrice) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.hourlyPrice = hourlyPrice;
    }
}
