package tn.esprit.Entities;

import java.sql.Time;

public class Trajet {
    private int idT;
    private String pointDep;
    private String pointArr;
    private double distance;
    private Time dureeEstime;
    private int idMoyen;
    private int idEmploye;
    private String status;

    // Constructeurs
    public Trajet() {
    }

    public Trajet(int idT, String pointDep, String pointArr, double distance, Time dureeEstime, int idMoyen, int idEmploye, String status) {
        this.idT = idT;
        this.pointDep = pointDep;
        this.pointArr = pointArr;
        this.distance = distance;
        this.dureeEstime = dureeEstime;
        this.idMoyen = idMoyen;
        this.idEmploye = idEmploye;
        this.status = status;
    }

    // Getters et Setters
    public int getIdT() {
        return idT;
    }

    public void setIdT(int idT) {
        this.idT = idT;
    }

    public String getPointDep() {
        return pointDep;
    }

    public void setPointDep(String pointDep) {
        this.pointDep = pointDep;
    }

    public String getPointArr() {
        return pointArr;
    }

    public void setPointArr(String pointArr) {
        this.pointArr = pointArr;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Time getDureeEstime() {
        return dureeEstime;
    }

    public void setDureeEstime(Time dureeEstime) {
        this.dureeEstime = dureeEstime;
    }

    public int getIdMoyen() {
        return idMoyen;
    }

    public void setIdMoyen(int idMoyen) {
        this.idMoyen = idMoyen;
    }

    public int getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(int idEmploye) {
        this.idEmploye = idEmploye;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Méthode toString pour affichage
    @Override
    public String toString() {
        return "Trajet{" +
                "idT=" + idT +
                ", pointDep='" + pointDep + '\'' +
                ", pointArr='" + pointArr + '\'' +
                ", distance=" + distance +
                ", dureeEstime=" + dureeEstime +
                ", idMoyen=" + idMoyen +
                ", idEmploye=" + idEmploye +
                ", status='" + status + '\'' +
                '}';
    }
}
