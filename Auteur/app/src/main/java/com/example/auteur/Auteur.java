package com.example.auteur;

public class Auteur {
    private int idAuteur;
    private String nomAuteur;
    private String prenomAuteur;
    private String dateNaissance;

    public Auteur() {
    }

    public Auteur(int idAuteur) {
        this.idAuteur = idAuteur;
    }

    public Auteur(String nomAuteur, String prenomAuteur, String dateNaissance) {
        this.nomAuteur = nomAuteur;
        this.prenomAuteur = prenomAuteur;
        this.dateNaissance = dateNaissance;
    }

    public Auteur(int idAuteur, String nomAuteur, String prenomAuteur, String dateNaissance) {
        this.idAuteur = idAuteur;
        this.nomAuteur = nomAuteur;
        this.prenomAuteur = prenomAuteur;
        this.dateNaissance = dateNaissance;
    }

    public int getIdAuteur() {
        return idAuteur;
    }

    public void setIdAuteur(int idAuteur) {
        this.idAuteur = idAuteur;
    }

    public String getNomAuteur() {
        return nomAuteur;
    }

    public void setNomAuteur(String nomAuteur) {
        this.nomAuteur = nomAuteur;
    }

    public String getPrenomAuteur() {
        return prenomAuteur;
    }

    public void setPrenomAuteur(String prenomAuteur) {
        this.prenomAuteur = prenomAuteur;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    @Override
    public String toString() {
        return "Auteur{" +
                "idAuteur=" + idAuteur +
                ", nomAuteur='" + nomAuteur + '\'' +
                ", prenomAuteur='" + prenomAuteur + '\'' +
                ", dateNaissance='" + dateNaissance + '\'' +
                '}';
    }
}


