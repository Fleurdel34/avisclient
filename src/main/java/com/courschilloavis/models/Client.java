package com.courschilloavis.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

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
    private String telephone;
    @UpdateTimestamp
    private LocalDateTime creation;
    @UpdateTimestamp
    @Column(name = "mis_a_jour")
    private LocalDateTime misAjour;


    public Client() {
    }

    public Client(Long id, String email, String telephone, LocalDateTime creation, LocalDateTime misAjour) {
        this.id = id;
        this.email = email;
        this.telephone = telephone;
        this.creation = creation;
        this.misAjour = misAjour;
    }

}
