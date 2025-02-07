package tn.esprit.Entities;
import java.util.Objects;

public class Candidate {
    private int idCandidate;
    private String name;
    private String email;
    private String phoneNumber;
    private String cv;
    private String status;

    // Constructeur par défaut
    public Candidate() {}

    // Constructeur avec paramètres
    public Candidate(int idCandidate, String name, String email, String phoneNumber, String cv, String status) {
        this.idCandidate = idCandidate;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.cv = cv;
        this.status = status;
    }

    // Getters et Setters
    public int getIdCandidate() {
        return idCandidate;
    }

    public void setIdCandidate(int idCandidate) {
        this.idCandidate = idCandidate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Méthode toString
    @Override
    public String toString() {
        return "Candidate{" +
                "idCandidate=" + idCandidate +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", cv='" + cv + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    // Méthode equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidate candidate = (Candidate) o;
        return idCandidate == candidate.idCandidate;
    }

    // Méthode hashCode
    @Override
    public int hashCode() {
        return Objects.hash(idCandidate);
    }
}
