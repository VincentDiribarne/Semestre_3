package com.example.uno.Autres;

public class Cartes {
    private int numero;
    private String image;
    private String couleur;
    private String carteSpe;

    public Cartes(int numero, String couleur) {
        this.numero = numero;
        this.couleur = couleur;
    }

    public int getNumero() {
        return numero;
    }

    public String getImage() {
        return image;
    }

    public String getCouleur() {
        return couleur;
    }

    public String getCarteSpe() {
        return carteSpe;
    }
}
