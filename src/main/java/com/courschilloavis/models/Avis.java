package com.courschilloavis.models;

import com.courschilloavis.enums.TypeAvis;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.PERSIST;

@Setter
@Getter
@Entity
@Table(name="AVIS")
public class Avis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String text;
    private TypeAvis type;
    @ManyToOne(cascade ={PERSIST, MERGE})
    @JoinColumn(name = "CLIENT_ID")
    private Client client;


    public Avis(String text, TypeAvis type, Client client) {
        this.text = text;
        this.type = type;
        this.client = client;
    }

    public Avis() {

    }
}
