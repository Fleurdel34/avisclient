package com.courschilloavis.models;

import com.courschilloavis.enums.TypeAvis;
import jakarta.persistence.*;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.PERSIST;

@Entity
@Table(name="AVIS")
public class Avis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String text;
    private TypeAvis Type;
    @ManyToOne(cascade ={PERSIST, MERGE})
    @JoinColumn(name = "CLIENT_ID")
    private Client client;

    public Avis() {
    }

    public Avis(long id, String text, TypeAvis type, Client client) {
        this.id = id;
        this.text = text;
        Type = type;
        this.client = client;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public TypeAvis getType() {
        return Type;
    }

    public void setType(TypeAvis type) {
        Type = type;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
