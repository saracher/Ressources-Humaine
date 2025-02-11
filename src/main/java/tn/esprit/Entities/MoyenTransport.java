package tn.esprit.Entities;

public class MoyenTransport {
    private int idMoyen;
    private String typeMoyen;
    private int capacite;
    private int immatriculation;
    private String status;

    // Constructeur par défaut
    public MoyenTransport() {
    }

    // Constructeur avec paramètres
    public MoyenTransport(int idMoyen, String typeMoyen, int capacite, int immatriculation, String status) {
        this.idMoyen = idMoyen;
        this.typeMoyen = typeMoyen;
        this.capacite = capacite;
        this.immatriculation = immatriculation;
        this.status = status;
    }

    // Getters et Setters
    public int getIdMoyen() {
        return idMoyen;
    }

    public void setIdMoyen(int idMoyen) {
        this.idMoyen = idMoyen;
    }

    public String getTypeMoyen() {
        return typeMoyen;
    }

    public void setTypeMoyen(String typeMoyen) {
        this.typeMoyen = typeMoyen;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public int getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(int immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Méthode toString() pour affichage
    @Override
    public String toString() {
        return "MoyenTransport{" +
                "idMoyen=" + idMoyen +
                ", typeMoyen='" + typeMoyen + '\'' +
                ", capacite=" + capacite +
                ", immatriculation=" + immatriculation +
                ", status='" + status + '\'' +
                '}';
    }
}
