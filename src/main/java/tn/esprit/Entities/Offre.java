package tn.esprit.Entities;

import java.util.Date;
import java.util.Objects;

public class Offre {
    private int idOffre;
    private String titre;
    private String description;
    private Date datePublication;
    private Date dateExpiration;

    // Constructeur par défaut
    public Offre() {}

    // Constructeur avec paramètres
    public Offre(int idOffre, String titre, String description, Date datePublication, Date dateExpiration) {
        this.idOffre = idOffre;
        this.titre = titre;
        this.description = description;
        this.datePublication = datePublication;
        this.dateExpiration = dateExpiration;
    }

    // Getters et Setters
    public int getIdOffre() {
        return idOffre;
    }

    public void setIdOffre(int idOffre) {
        this.idOffre = idOffre;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }

    public Date getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(Date dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    // Méthode toString
    @Override
    public String toString() {
        return "Offre{" +
                "idOffre=" + idOffre +
                ", titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                ", datePublication=" + datePublication +
                ", dateExpiration=" + dateExpiration +
                '}';
    }

    // Méthode equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offre offre = (Offre) o;
        return idOffre == offre.idOffre;
    }

    // Méthode hashCode
    @Override
    public int hashCode() {
        return Objects.hash(idOffre);
    }
}

