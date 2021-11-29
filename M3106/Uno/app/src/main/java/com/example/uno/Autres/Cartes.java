package com.example.uno.Autres;

public class Cartes {
    private int numero;
    private String image;
    private String couleur;
    private String carteSpe;

    public Cartes(int numero, String couleur, String image) {
        this.numero = numero;
        this.image = image;
        this.couleur = couleur;
    }

    public Cartes(String couleur, String image, String carteSpe) {
        this.image = image;
        this.couleur = couleur;
        this.carteSpe = carteSpe;
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
