package id.yozi.kpmservice.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;

@Entity(name = "Users")
@Data
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String email;

    private String password;

    private String token;

    private BigInteger expiredAt;
}
