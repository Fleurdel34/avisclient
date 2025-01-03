package com.courschilloavis.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Date;

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
    private Date creation;
    @Column(name = "mis_a_jour")
    private Date misAjour;


    public Client() {
    }

    public Client(Long id, String email, String telephone, Date creation, Date misAjour) {
        this.id = id;
        this.email = email;
        this.telephone = telephone;
        this.creation = creation;
        this.misAjour = misAjour;
    }
}
