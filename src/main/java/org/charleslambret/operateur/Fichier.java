package org.charleslambret.operateur;

public class Fichier {
    private int id;
    private String nom;
    private String type;

    public Fichier(int id, String nom, String type) {
        this.id = id;
        this.nom = nom;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getType() {
        return type;
    }
}
