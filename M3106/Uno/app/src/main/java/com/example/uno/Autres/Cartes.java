package com.example.uno.Autres;

public class Cartes {
    private String numero;
    private String image;
    private Couleur couleur;
    private int carteSpe;

    public Cartes(String numero, Couleur couleur) {
        this.numero = numero;
        this.couleur = couleur;
    }

    public Cartes(Couleur couleur, int source) {
        this.couleur = couleur;
        this.carteSpe = source;
    }

    public String getNumero() {
        return numero;
    }

    public String getImage() {
        return image;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public int getCarteSpe() {
        return carteSpe;
    }
}
