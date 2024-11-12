package com.courschilloavis.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Setter
@Getter
@Entity
@Table(name="CLIENT")
public class Client {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    public Client() {
    }

    public Client(Long id, String email) {
        this.id = id;
        this.email = email;
    }

}
