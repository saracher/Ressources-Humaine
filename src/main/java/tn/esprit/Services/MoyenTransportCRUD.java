package tn.esprit.Services;

import tn.esprit.Entities.MoyenTransport;
import tn.esprit.Utils.MyDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MoyenTransportCRUD implements CRUD_M {

    private Connection cnx;

    public MoyenTransportCRUD() {
        cnx = MyDataBase.getInstance().getConnection();
    }

    @Override
    public void ajouter(MoyenTransport mt) {
        String req = "INSERT INTO MoyenTransport (type_moyen, capacité, immatriculation, status) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pst = cnx.prepareStatement(req)) {
            pst.setString(1, mt.getTypeMoyen());
            pst.setInt(2, mt.getCapacite());
            pst.setInt(3, mt.getImmatriculation());
            pst.setString(4, mt.getStatus());
            pst.executeUpdate();
            System.out.println("✅ Moyen de transport ajouté avec succès !");
        } catch (SQLException e) {
            System.out.println("❌ Erreur lors de l'ajout : " + e.getMessage());
        }
    }

    @Override
    public List<MoyenTransport> afficher() {
        List<MoyenTransport> list = new ArrayList<>();
        String req = "SELECT * FROM MoyenTransport";
        try (Statement st = cnx.createStatement(); ResultSet rs = st.executeQuery(req)) {
            while (rs.next()) {
                MoyenTransport mt = new MoyenTransport(
                        rs.getInt("id_moyen"),
                        rs.getString("type_moyen"),
                        rs.getInt("capacité"),
                        rs.getInt("immatriculation"),
                        rs.getString("status")
                );
                list.add(mt);
            }
        } catch (SQLException e) {
            System.out.println("❌ Erreur lors de l'affichage : " + e.getMessage());
        }
        return list;
    }

    @Override
    public void modifier(MoyenTransport mt) {
        String req = "UPDATE MoyenTransport SET type_moyen=?, capacité=?, immatriculation=?, status=? WHERE id_moyen=?";
        try (PreparedStatement pst = cnx.prepareStatement(req)) {
            pst.setString(1, mt.getTypeMoyen());
            pst.setInt(2, mt.getCapacite());
            pst.setInt(3, mt.getImmatriculation());
            pst.setString(4, mt.getStatus());
            pst.setInt(5, mt.getIdMoyen());
            pst.executeUpdate();
            System.out.println("✅ Moyen de transport mis à jour !");
        } catch (SQLException e) {
            System.out.println("❌ Erreur lors de la modification : " + e.getMessage());
        }
    }

    @Override
    public void supprimer(int id) {
        String req = "DELETE FROM MoyenTransport WHERE id_moyen=?";
        try (PreparedStatement pst = cnx.prepareStatement(req)) {
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("✅ Moyen de transport supprimé !");
        } catch (SQLException e) {
            System.out.println("❌ Erreur lors de la suppression : " + e.getMessage());
        }
    }
}
