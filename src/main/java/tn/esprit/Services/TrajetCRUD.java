package tn.esprit.Services;

import tn.esprit.Entities.Trajet;
import tn.esprit.Utils.MyDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TrajetCRUD implements CRUD<Trajet> {
    private Connection cnx;

    public TrajetCRUD() {
        cnx = MyDataBase.getInstance().getConnection();
    }

    // Vérifier si l'abonnement de l'employé est actif
    private boolean verifierAbonnementActif(int employeId) {
        String query = "SELECT status FROM abonnement WHERE id_employe = ?";
        try (PreparedStatement pst = cnx.prepareStatement(query)) {
            pst.setInt(1, employeId);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return "actif".equalsIgnoreCase(rs.getString("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Vérifier si le moyen de transport est disponible
    private boolean verifierMoyenTransportDisponible(int moyenId) {
        String query = "SELECT status FROM moyentransport WHERE id_moyen = ?"; // Utiliser 'id_moyen' ou votre colonne réelle
        try (PreparedStatement pst = cnx.prepareStatement(query)) {
            pst.setInt(1, moyenId);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return "disponible".equalsIgnoreCase(rs.getString("status")); // Vérifier si le statut est "disponible"
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Ajouter un trajet avec vérification
    @Override
    public void ajouter(Trajet t) {
        if (!verifierAbonnementActif(t.getIdEmploye())) {
            System.out.println("❌ L'employé n'a pas d'abonnement actif.");
            return;
        }

        if (!verifierMoyenTransportDisponible(t.getIdMoyen())) {
            System.out.println("❌ Le moyen de transport sélectionné n'est pas disponible.");
            return;
        }

        String query = "INSERT INTO trajet (point_dep, point_arr, distance, durée_estimé, id_moyen, id_employe, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pst = cnx.prepareStatement(query)) {
            pst.setString(1, t.getPointDep());
            pst.setString(2, t.getPointArr());
            pst.setDouble(3, t.getDistance());
            pst.setTime(4, t.getDureeEstime());
            pst.setInt(5, t.getIdMoyen());
            pst.setInt(6, t.getIdEmploye());
            pst.setString(7, t.getStatus());

            pst.executeUpdate();
            System.out.println("✅ Trajet ajouté avec succès !");
        } catch (SQLException e) {
            System.err.println("❌ Erreur lors de l'ajout du trajet : " + e.getMessage());
        }
    }

    // Afficher tous les trajets
    @Override
    public List<Trajet> afficher() {
        List<Trajet> trajets = new ArrayList<>();
        String query = "SELECT * FROM trajet";
        try (Statement stmt = cnx.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Trajet t = new Trajet(
                        rs.getInt("id_T"),
                        rs.getString("point_dep"),
                        rs.getString("point_arr"),
                        rs.getDouble("distance"),
                        rs.getTime("durée_estimé"),
                        rs.getInt("id_moyen"),
                        rs.getInt("id_employe"),
                        rs.getString("status")
                );
                trajets.add(t);
            }
        } catch (SQLException e) {
            System.err.println("❌ Erreur lors de l'affichage des trajets : " + e.getMessage());
        }
        return trajets;
    }

    // Modifier un trajet
    @Override
    public void modifier(Trajet t) {
        String query = "UPDATE trajet SET point_dep=?, point_arr=?, distance=?, durée_estimé=?, id_moyen=?, id_employe=?, status=? WHERE id_T=?";
        try (PreparedStatement pst = cnx.prepareStatement(query)) {
            pst.setString(1, t.getPointDep());
            pst.setString(2, t.getPointArr());
            pst.setDouble(3, t.getDistance());
            pst.setTime(4, t.getDureeEstime());
            pst.setInt(5, t.getIdMoyen());
            pst.setInt(6, t.getIdEmploye());
            pst.setString(7, t.getStatus());
            pst.setInt(8, t.getIdT());

            int rowsUpdated = pst.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("✅ Trajet modifié avec succès !");
            } else {
                System.out.println("⚠ Aucun trajet trouvé avec cet ID !");
            }
        } catch (SQLException e) {
            System.err.println("❌ Erreur lors de la modification du trajet : " + e.getMessage());
        }
    }

    // Supprimer un trajet
    @Override
    public void supprimer(int id) {
        String query = "DELETE FROM trajet WHERE id_T=?";
        try (PreparedStatement pst = cnx.prepareStatement(query)) {
            pst.setInt(1, id);

            int rowsDeleted = pst.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("✅ Trajet supprimé avec succès !");
            } else {
                System.out.println("⚠ Aucun trajet trouvé avec cet ID !");
            }
        } catch (SQLException e) {
            System.err.println("❌ Erreur lors de la suppression du trajet : " + e.getMessage());
        }
    }
}
