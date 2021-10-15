package com.example.td1;

public class Message {

    private String id;
    private String nom;
    private String text;

    public Message() {

    }

    public Message(String nom, String text) {
        this.id = id;
        this.nom = nom;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
